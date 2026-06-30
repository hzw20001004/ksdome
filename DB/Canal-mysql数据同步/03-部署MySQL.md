# 03 · 部署 MySQL（目标库 sig-mysql-txg）

> 编排文件：`docker-compose-dev测试-mysql优化.yml`
> 容器名：`sig-mysql-txg`
> 目标库：`jielong`（与 RDS 源库同名，整库镜像）

## 3.1 前置检查

```bash
# 1. 目录已建（见 02-环境准备.md 2.3.1）
ls -ld /home/txg/mysql/{db,conf,data,log}
# 期望: 4 个目录都存在

# 2. 端口 13306 未被占用
ss -lntp | grep 13306 || echo "OK, 端口空闲"

# 3. 磁盘空间足够 (≥ 80G)
df -h /home/txg
```

## 3.2 上传 compose 文件

```bash
# 本地 → 服务器
scp "docker-compose-dev测试-mysql优化.yml" root@SERVER_IP:/home/txg/mysql/docker-compose.yml

# 服务器上确认
cd /home/txg/mysql
ls -la docker-compose.yml
```

## 3.3 关键配置解读

### 3.3.1 资源限制

```yaml
deploy:
  resources:
    limits:
      cpus: '12'        # 最多用 12 核
      memory: 40G       # 最多用 40G 内存
    reservations:
      cpus: '8'
      memory: 32G
shm_size: '2g'          # 共享内存 2G（MySQL 8 InnoDB 用）
```

> 注意：`deploy.resources` 在 `docker compose up`（非 swarm）下 **仍然生效**，作为容器资源上限。

### 3.3.2 InnoDB 关键参数（背板 28G buffer pool）

| 参数 | 值 | 作用 |
|---|---|---|
| `innodb_buffer_pool_size` | `28G` | 数据缓存，吃满 70% 可用内存的常规建议 |
| `innodb_buffer_pool_instances` | `16` | 配合 28G，每个实例 ~1.75G，减少锁竞争 |
| `innodb_redo_log_capacity` | `2G` | MySQL 8 新参数（替代旧的 log_file_size） |
| `innodb_flush_log_at_trx_commit` | `2` | 性能优先（每次提交刷 OS buffer 而非 fsync），崩溃可能丢 1 秒数据 |
| `innodb_flush_method` | `O_DIRECT` | 绕过 OS buffer，避免 double buffering |
| `innodb_io_capacity` / `_max` | `2000` / `4000` | SSD 推荐值，刷脏页速度 |
| `innodb_read_io_threads` / `write_io_threads` | `8` / `8` | IO 线程数 |

### 3.3.3 复制相关（canal-adapter 写入会用）

```bash
--server-id=2                    # 唯一 ID
--replicate-do-db=jielong        # 只复制 jielong 库（canal 写入限定）
--log-bin=mysql-bin              # 开 binlog（虽然 canal 是直接 JDBC 写，但 MySQL 自己也需要 binlog 用于崩溃恢复）
```

> 注意：原始 yml 同时有 `--skip-log-bin` 和 `--log-bin=mysql-bin`。MySQL 启动时**后者先生效**（参数顺序）。
> 如果确实要彻底关 binlog 节省空间，删掉 `--log-bin=mysql-bin` 那行只保留 `--skip-log-bin`。
> 本次目标是接收 canal 同步，**保留 binlog 没问题**（可选）。

### 3.3.4 字符集 / 时区 / 连接数

```bash
--character-set-server=utf8mb4
--collation-server=utf8mb4_general_ci
--max_connections=500
--max_allowed_packet=256M         # canal 批量 INSERT 可能很大
--slow_query_log=1
--long_query_time=2               # 慢查询阈值 2 秒，便于发现同步瓶颈
```

## 3.4 启动 MySQL

```bash
cd /home/txg/mysql

# 拉镜像 + 后台启动
docker compose up -d

# 查看启动状态
docker compose ps
# 期望: sig-mysql-txg   Up   (healthy) 

# 看启动日志（确认无报错）
docker compose logs -f sig-mysql-txg
# 看到 "MySQL Community Server ... started" 即可 Ctrl+C 退出
```

## 3.5 初始化目标库

canal-adapter 启动后会自动建表（mirrorDb 模式下），但**库本身需要先建好**：

```bash
# 进 MySQL 容器
docker exec -it sig-mysql-txg mysql -uroot -p'Aw123456.'

# 在 MySQL 提示符下:
CREATE DATABASE IF NOT EXISTS jielong
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

# 验证
SHOW DATABASES LIKE 'jielong';
# 期望: jielong 出现

# 看字符集
SHOW VARIABLES LIKE 'character_set_server';
SHOW VARIABLES LIKE 'innodb_buffer_pool_size';
# 期望: utf8mb4 / 30064771072 (= 28G)

exit;
```

> 表结构本身不用手动建。canal-adapter 启动后会从 RDS 拉元数据自动在本地建同名表（mirrorDb 模式）。
> 如果担心自动建表行为，可以先用 mysqldump 把 RDS 的 jielong 库结构（不含数据）导一份到本地。

## 3.6 健康检查

```bash
# 1. 容器存活
docker ps --filter name=sig-mysql-txg --format '{{.Names}}\t{{.Status}}'

# 2. 端口监听
docker exec sig-mysql-txg ss -lntp | grep 3306
# 期望: mysqld 监听 0.0.0.0:3306

# 3. 宿主机端口映射
ss -lntp | grep 13306

# 4. 远程连接测试（从 canal-adapter 容器视角）
docker run --rm mysql:8.0.36 \
  mysql -h sig-mysql-txg -P 3306 -uroot -p'Aw123456.' -e "SELECT VERSION();"
# 注意: 这条要在 canal-adapter 同 network 下才能解析 sig-mysql-txg
```

## 3.7 常见启动失败

| 报错 | 原因 | 解决 |
|---|---|---|
| `mbind: Operation not permitted` | 宿主机内核 numa 限制 | 加 `--cap-add=SYS_NICE` 或忽略（warning 无害） |
| 启动卡住 / OOM | 内存超卖 | 把 `innodb_buffer_pool_size` 调小 |
| 端口 13306 已占用 | 旧实例未停 | `docker ps -a` 找出并 `docker rm -f` |
| `/var/lib/mysql` 不是空目录 | `/home/txg/mysql/db` 之前初始化过 | 清空 `db/` 目录后重试（注意：会丢数据） |

## 3.8 自检清单

- [ ] `docker compose ps` 显示 healthy
- [ ] MySQL 版本 8.0.36，字符集 utf8mb4
- [ ] `innodb_buffer_pool_size` ≈ 28G
- [ ] `jielong` 库已创建
- [ ] canal-adapter 容器能 `mysql -h sig-mysql-txg` 连通

确认后，进入 [04-部署Canal-Server.md](04-部署Canal-Server.md)。
