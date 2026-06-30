# 04 · 部署 Canal-Server

> 编排文件：`docker-compose-dev测试-Canal+CanalAdmin-优化.yml`（含 server + adapter 两节）
> 容器名：`canal-server`
> 作用：伪装成阿里云 RDS 的从库，读取 binlog

## 4.1 阿里云 RDS 侧前置（最重要！）

canal-server 启动前，RDS 必须**先**做这三件事，否则 server 起不来或解析失败。

### 4.1.1 开启 binlog（row 格式）

阿里云 RDS 控制台 → 参数设置：

| 参数 | 要求值 | 验证 |
|---|---|---|
| `binlog_format` | `ROW` | `SHOW GLOBAL VARIABLES LIKE 'binlog_format';` |
| `binlog_row_image` | `FULL` | `SHOW GLOBAL VARIABLES LIKE 'binlog_row_image';` |
| `log_bin` | `ON` | `SHOW VARIABLES LIKE 'log_bin';` |
| `binlog retention hours` | ≥ 24（推荐 72） | RDS 控制台 → 数据备份 → binlog 保留 |

> 改参数后 RDS 会自动重启 replica（不影响主库），等几分钟生效。

### 4.1.2 创建同步账号（已存在则跳过）

```sql
-- 在 RDS 上执行 (用高权限账号)
CREATE USER 'systemdba'@'%' IDENTIFIED BY 'gRdrqp3LLuSgdgZH';
GRANT SELECT, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'systemdba'@'%';
FLUSH PRIVILEGES;
```

> 账号密码要与 `jielong-instance.properties` 里 `canal.instance.dbUsername/dbPassword` 一致。

### 4.1.3 加 `__#alibaba_rds_row_id#__` 列（canal 行级订阅必需）

阿里云 RDS 在 binlog 里需要这个隐藏列来标识行版本。canal-server 解析依赖它。

执行 `canal-server-conf/数据库.md` 里的两段 SQL：

```sql
-- 第一步: 生成 ALTER 语句 (review)
USE jielong;
SELECT CONCAT(
  'ALTER TABLE `', TABLE_NAME,
  '` ADD COLUMN `__#alibaba_rds_row_id#__` BIGINT UNSIGNED NULL;'
) AS ddl_to_run
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'jielong'
  AND TABLE_TYPE = 'BASE TABLE'
  AND NOT EXISTS (
    SELECT 1 FROM information_schema.COLUMNS
    WHERE TABLE_SCHEMA = 'jielong'
      AND TABLE_NAME = information_schema.TABLES.TABLE_NAME
      AND COLUMN_NAME = '__#alibaba_rds_row_id#__'
  );

-- 第二步: 把上面 SELECT 输出的所有 ALTER 语句复制执行一遍
-- 注意: 列名两边的反引号 ` 不能省, 因为列名里含 #
```

> 这一步**只做一次**，新建的表 RDS 会自动加该列。
> 如果跳过这步，canal 启动可能不报错但**同步某些表会丢数据**。

### 4.1.4 白名单

RDS 控制台 → 数据安全性 → 白名单设置：加入 canal-server 机器的出口 IP（公网 IP 或 VPC 内网 IP）。

```bash
# canal-server 机器上测试连通性
mysql -h rm-bp1c2x3191qxo5o7x8o.mysql.rds.aliyuncs.com -u systemdba -p'gRdrqp3LLuSgdgZH' -e "SELECT 1;"
# 期望: 1
```

## 4.2 上传配置文件

```bash
# 本地 → 服务器（4 个文件）
scp canal-server-conf/canal.properties           root@SERVER_IP:/home/canal/canal-server-conf/
scp canal-server-conf/jielong-instance.properties root@SERVER_IP:/home/canal/canal-server-conf/
scp canal-server-conf/logback.xml                root@SERVER_IP:/home/canal/canal-server-conf/
scp "docker-compose-dev测试-Canal+CanalAdmin-优化.yml" root@SERVER_IP:/home/canal/docker-compose.yml

# 服务器确认
ls -la /home/canal/canal-server-conf/
# 期望: canal.properties / jielong-instance.properties / logback.xml
```

## 4.3 关键配置解读

### 4.3.1 canal.properties（全局）

```properties
# 必填: 工作模式
canal.serverMode = tcp                              # 直连模式（不走 MQ）
canal.destinations = jielong                        # 必填: 显式列出实例名

# 必填: 实例加载方式（独立模式，不依赖 canal-admin）
canal.instance.global.mode = spring
canal.instance.global.spring.xml = classpath:spring/file-instance.xml

# 关键: 关闭自动扫描（否则会加载镜像自带的 conf/example/ 报错）
canal.auto.scan = false
```

> ⚠️ 这些属性在 canal 1.1.5 里都是**必填**，缺失会导致 `CanalStarter.start()` 第 68 行 NPE 或 `CanalController.initInstanceConfig` 第 396 行 NPE。详见 [06-验证与排错.md](06-验证与排错.md)。

### 4.3.2 jielong-instance.properties（实例）

```properties
# 1. RDS 连接（重点：journal.name / position / timestamp / gtid 全部留空 = 从最新位点开始）
canal.instance.master.address = rm-bp1c2x3191qxo5o7x8o.mysql.rds.aliyuncs.com:3306
canal.instance.master.journal.name =              # 空 = 从当前位点
canal.instance.master.position =                  # 空 = 从当前位点
canal.instance.master.timestamp =                 # 空 = 从当前位点
canal.instance.master.gtid =                      # 空 = 不用 GTID

# 2. 账号
canal.instance.dbUsername = systemdba
canal.instance.dbPassword = gRdrqp3LLuSgdgZH
canal.instance.defaultDatabaseName = jielong

# 3. 订阅规则: 只同步 jielong 库的所有表
canal.instance.filter.regex = jielong\\..*

# 4. TSDB (Table Structure Database): 记录表结构历史版本
canal.instance.tsdb.enable = true
canal.instance.tsdb.url = jdbc:mysql://rm-bp1c2x3191qxo5o7x8o.mysql.rds.aliyuncs.com:3306/jielong

# 5. 并行解析（32 核机器优化）
canal.instance.parser.parallel = true              # 默认 true, 显式开启
canal.instance.parser.parallelBufferSize = 512     # 必须是 2 的幂, 默认 256
# parallelThreadSize 不要显式设！源码 fallback = 60% 核心数 = 32 核机器自动 19 线程
```

> ⚠️ `parallelBufferSize` 必须是 **2 的幂**（256 / 512 / 1024 / ...），否则 canal 内部 ring buffer 会抛 IllegalArgumentException。
>
> ⚠️ `parallelThreadSize` 显式设了反而可能更慢（不熟悉时容易设小）。让它走 fallback 自动算。

### 4.3.3 实例目录命名（关键）

canal-server 启动时按以下顺序找实例配置：

1. `/home/admin/canal-server/conf/<destination>/instance.properties`
2. `canal.properties` 里的 `canal.destinations = jielong` 必须与之一致

所以 docker-compose 里挂载时：

```yaml
- "/home/canal/canal-server-conf/jielong-instance.properties:/home/admin/canal-server/conf/jielong/instance.properties"
```

注意：源文件叫 `jielong-instance.properties`，但挂进容器时**路径必须**是 `conf/jielong/instance.properties`（去掉前缀，目录名 = destination）。

### 4.3.4 logback.xml（日志策略）

适配 canal-server 1.1.5 自带的 logback 1.1.3，**只能用老语法**：

| 老写法（1.1.3） | 新写法（1.1.7+，会报错） |
|---|---|
| `<rollingPolicy class="TimeBasedRollingPolicy">` + 内嵌 `<timeBasedFileNamingAndTriggeringPolicy class="SizeAndTimeBasedFNATP">` | `<rollingPolicy class="SizeAndTimeBasedRollingPolicy">` |

日志策略：

- 单文件 5MB
- 按天滚动
- 保留 30 天
- 总大小：canal 主日志 20GB / 实例日志 10GB / 错误日志 5GB

## 4.4 启动 canal-server

```bash
cd /home/canal

# 只起 server（adapter 也用同一个 yml）
docker compose up -d canal-server

# 查看状态
docker compose ps canal-server
# 期望: canal-server   Up

# 看启动日志（关注是否连上 RDS）
docker compose logs -f canal-server
```

### 启动成功的标志

日志里依次出现：

```
## start the canal server: jielong
## the canal server is running now ......
[main] INFO  c.a.otter.canal.parse.inbound.mysql.MysqlEventParser - --> begin to find start position
[main] INFO  c.a.o.c.parse.inbound.mysql.dbsync.DirectLogFetcher - MASTER: rm-bp1c2x3191qxo5o7x8o:3306
```

只要看到 `find start position` 后无 ERROR，说明已连上 RDS 并开始拉 binlog。

## 4.5 验证 canal-server

```bash
# 1. 端口监听
docker exec canal-server ss -lntp | grep -E '11111|11112'
# 期望: 11111 (数据) 和 11112 (metrics) 都监听

# 2. 实例加载成功
docker exec canal-server ls /home/admin/canal-server/conf/
# 期望: 看到 jielong 目录（自动创建）

# 3. 监听位点已记录
docker exec canal-server cat /home/admin/canal-server/conf/jielong/meta.dat 2>/dev/null || \
  docker exec canal-server find /home/admin/canal-server -name 'meta.dat'
# 这个文件记录当前 binlog 位点

# 4. metrics 接口
curl http://localhost:11112/metrics
# 期望: Prometheus 格式数据
```

## 4.6 常见启动失败

| 报错关键词 | 原因 | 解决 |
|---|---|---|
| `CanalStarter NPE at line 68` | `canal.serverMode` 没配 | 已在 canal.properties 配 `tcp`，重启容器 |
| `CanalController NPE at line 396` | `canal.destinations` 没配或与目录不一致 | 检查 `canal.destinations = jielong` 和挂载路径 |
| `Could not find first log file name in binary log index` | `master.journal.name` 设了但 RDS 上不存在 | 全部留空让 canal 从当前位点开始 |
| `Rotation binlog file not match` | RDS binlog 保留时间太短被清理 | RDS 控制台调长 binlog retention hours |
| `Access denied for user 'systemdba'` | 账号权限不够 | `GRANT REPLICATION SLAVE, REPLICATION CLIENT` |
| `ringbuffer size 513 is not a power of 2` | `parallelBufferSize` 不是 2 的幂 | 改为 256 / 512 / 1024 |
| 找不到 `conf/example/` | `canal.auto.scan = true` 误开 | 改为 `false` |

## 4.7 自检清单

- [ ] RDS 4.1.1-4.1.4 全部完成
- [ ] 4 个配置文件已上传到 `/home/canal/canal-server-conf/` 和 `/home/canal/`
- [ ] `canal-server` 容器 Up 状态
- [ ] 日志无 ERROR，已看到 `find start position`
- [ ] 11111 端口监听
- [ ] `meta.dat` 文件已生成

确认后进入 [05-部署Canal-Adapter.md](05-部署Canal-Adapter.md)。
