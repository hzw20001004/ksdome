# 05 · 部署 Canal-Adapter

> 编排文件：`docker-compose-dev测试-Canal+CanalAdmin-优化.yml`（与 server 同一个文件）
> 容器名：`canal-adapter`
> 作用：消费 canal-server 的 binlog 数据，转成 SQL 写入本地 MySQL

## 5.1 前置检查

```bash
# 1. canal-server 已起且监听 11111
docker exec canal-server ss -lntp | grep 11111

# 2. 目标 MySQL 已起，jielong 库已建（见 03-部署MySQL.md）
docker exec sig-mysql-txg mysql -uroot -p'Aw123456.' -e "SHOW DATABASES LIKE 'jielong'"

# 3. adapter 能解析 sig-mysql-txg 主机名（同一 network）
docker exec canal-server ping -c 1 sig-mysql-txg 2>&1 | head -1 || \
  echo "⚠️ canal-server 也连不到 sig-mysql-txg, 网络问题"
```

## 5.2 上传配置文件

```bash
# 本地 → 服务器（2 个文件 + rdb 子目录）
scp canal-adapter-conf/application.yml       root@SERVER_IP:/home/canal/canal-adapter-conf/
scp canal-adapter-conf/rdb/jielong.yml       root@SERVER_IP:/home/canal/canal-adapter-conf/rdb/

# 服务器确认
ls -la /home/canal/canal-adapter-conf/
ls -la /home/canal/canal-adapter-conf/rdb/
```

> 注意：docker-compose 里挂载的 `application.yml` 单独指定，而 `rdb` 目录是整目录挂载。所以两处路径都要正确。

## 5.3 关键配置解读

### 5.3.1 application.yml（全局 + 数据源 + 适配器）

**a) Server 端口**
```yaml
server:
  port: 8081              # Canal-Adapter REST 接口
```

**b) Canal-Server 连接参数（吞吐关键）**

```yaml
canal.conf:
  mode: tcp
  flatMessage: true
  syncBatchSize: 5000       # 原 1000 → 5000, 一次提交批量大
  retries: -1               # 无限重试
  consumerProperties:
    canal.tcp.server.host: canal-server:11111   # 通过服务名连
    canal.tcp.batch.size: 2000                  # 原 500 → 2000, 单次拉取消息数
```

**c) 源数据源（canal-adapter 用来读 RDS 表结构）**

```yaml
srcDataSources:
  defaultDS:
    url: jdbc:mysql://rm-bp1c2x3191qxo5o7x8o.mysql.rds.aliyuncs.com:3306/jielong?...
    username: systemdba
    password: gRdrqp3LLuSgdgZH
```

> `srcDataSources` **不是**用来读 binlog 的（那是 canal-server 的事），而是 adapter 用来：
> - 拉取表结构（DDL 同步）
> - 反查列信息（构造 INSERT/UPDATE）

**d) 适配器列表**

```yaml
canalAdapters:
- instance: jielong                # 必须与 canal-server 的 destination 一致
  groups:
  - groupId: g1
    outerAdapters:
    - name: logger                 # 仅日志输出（调试用）
    - name: rdb                    # 真正写入 MySQL 的适配器
      key: mysqlKey
      properties:
        jdbc.driverName: com.mysql.cj.jdbc.Driver
        jdbc.url: jdbc:mysql://sig-mysql-txg:3306/jielong?...&rewriteBatchedStatements=true&serverTimezone=Asia/Shanghai
        jdbc.username: root
        jdbc.password: Aw123456.
        threads: 20                # 原 5 → 20, 32 核机器支撑
```

> **`rewriteBatchedStatements=true`**：JDBC 把多条 INSERT 合并成一条，**批量写入利器**，强烈推荐。
> **`serverTimezone=Asia/Shanghai`**：避免时区告警。
> **`threads: 20`**：写入并发。32 核机器用 20 比较稳。再加可能把 MySQL 写挂。

### 5.3.2 rdb/jielong.yml（表/库映射）

```yaml
outerAdapterKey: mysqlKey         # 必须与 application.yml 里 outerAdapters[].key 一致
destination: jielong              # 必须与 canal-server destination 一致
groupId: g1                       # 必须与 application.yml groupId 一致
dbMapping:
  mirrorDb: true                  # ⭐ 整库镜像（DDL + DML 全部同步）
  database: jielong               # 源 = 目标 = jielong
```

`mirrorDb: true` 三大效果：

1. **整库同步**：jielong 库下所有表自动同步，不需要逐表配置
2. **DDL 自动应用**：RDS 上 ALTER/CREATE 会自动在目标库重放
3. **自动建表**：目标库没的表，adapter 会按 RDS 结构自动建

> ⚠️ `outerAdapterKey`、`destination`、`groupId` **三个值** 必须在 application.yml 和 jielong.yml 之间严格一致。一个对不上 adapter 就收不到数据。

### 5.3.3 mirrorDb 模式下不需要的字段

如果用 `mirrorDb: true`，**不要**再配以下字段（会冲突）：

| 字段 | mirrorDb=true 时 | 单表模式时 |
|---|---|---|
| `table` | ❌ 不要配 | ✅ 必填 |
| `targetTable` | ❌ 不要配 | ✅ 可选 |
| `targetDB` | ❌ 不要配 | ✅ 可选 |
| `mappingCamelCase` | ❌ 不要配 | ✅ 可选 |
| `targetColumns` / `targetPk` / `targetFields` | ❌ 不要配 | ✅ 可选 |

## 5.4 启动 canal-adapter

```bash
cd /home/canal

# 只起 adapter（server 已起）
docker compose up -d canal-adapter

# 查看状态
docker compose ps canal-adapter
# 期望: canal-adapter   Up

# 看启动日志
docker compose logs -f canal-adapter
```

### 启动成功的标志

日志里依次出现：

```
## start the canal client adapters in batch mode
## preStart adaptor: logger
## preStart adaptor: rdb
[main] INFO  c.a.o.canal.adapter.launcher.loader.CanalAdapterLoader - ## start canal adapters successful
[main] INFO  c.a.otter.canal.connector.tcp.consumer.CanalTCPConsumer   - destination[jielong] from canal-server[canal-server:11111]
```

看到 `start canal adapters successful` + `destination[jielong]` 即成功。

## 5.5 验证 canal-adapter

### 5.5.1 服务存活

```bash
docker ps --filter name=canal-adapter --format '{{.Names}}\t{{.Status}}'
```

### 5.5.2 REST 接口

```bash
# 1. 健康检查
curl http://localhost:8081/
# 期望: 返回 JSON, "status":"UP"

# 2. 当前订阅的 destination
curl http://localhost:8081/destinations
# 期望: ["jielong"]

# 3. 同步位点
curl http://localhost:8081/syncSwitch/jielong
# 期望: {"status":"ON"}
```

### 5.5.3 实际同步测试（关键）

在 **RDS 上** 执行一条 INSERT：

```sql
-- RDS 上
USE jielong;
-- 假设有测试表 test_canal (id INT PRIMARY KEY, val VARCHAR(50))
INSERT INTO test_canal(id, val) VALUES(99999, 'canal-sync-test-' NOW());
COMMIT;
```

5-10 秒内在 **本地 MySQL** 验证：

```bash
docker exec -it sig-mysql-txg mysql -uroot -p'Aw123456.' jielong -e \
  "SELECT * FROM test_canal WHERE id=99999;"
```

期望：能看到刚插入的那条记录。验证后删除：

```sql
-- RDS 上
DELETE FROM jielong.test_canal WHERE id=99999;
-- 几秒后本地也会自动删除
```

## 5.6 性能验证

```bash
# 1. 看 adapter 当前消息积压
docker compose logs --tail=100 canal-adapter | grep -E 'batch|sink'

# 2. 看 MySQL 写入速度（慢查询日志里 2 秒以上的）
docker exec sig-mysql-txg mysql -uroot -p'Aw123456.' -e \
  "SHOW VARIABLES LIKE 'slow_query_log%'; SELECT COUNT(*) FROM mysql.slow_log;"

# 3. JVM 状态（通过 metrics）
curl http://localhost:8081/metrics 2>/dev/null | grep -E 'jvm|canal'
```

## 5.7 常见启动失败

| 报错关键词 | 原因 | 解决 |
|---|---|---|
| `Connection refused: canal-server:11111` | adapter 和 server 不在同一 network | 见 02-环境准备.md 2.5 网络方案 |
| `Unknown database 'jielong'` | 目标库没建 | `CREATE DATABASE jielong;`（见 03） |
| `Access denied for user 'root'` | application.yml 密码错 | 改 `jdbc.password` |
| `outerAdapterKey not match` | application.yml 与 rdb/*.yaml 的 key 不一致 | 两边都设 `mysqlKey` |
| `destination[xxx] not found` | destination 名字不一致 | 三处都对齐 `jielong` |
| `Table 'jielong.xxx' doesn't exist` | mirrorDb 自动建表失败 | 看 adapter 日志，常见是 RDS 表用了不支持的数据类型 |
| 启动后不同步 | 同步开关被关 | `curl -X PUT http://localhost:8081/syncSwitch/jielong -d 'on=true'` |
| OOM / GC overhead | JVM 堆不够 | 已设 `-Xms4g -Xmx4g`，仍不够则调到 8G |

## 5.8 重启 / 热加载

```bash
# 重启（注意顺序：先 adapter，再 server）
docker compose restart canal-adapter
docker compose restart canal-server

# 热加载 rdb 配置（不重启容器）
curl -X POST http://localhost:8081/rdb/reload/jielong
```

## 5.9 自检清单

- [ ] canal-adapter 容器 Up
- [ ] 日志看到 `start canal adapters successful`
- [ ] REST `/` 返回 `"status":"UP"`
- [ ] REST `/destinations` 含 `jielong`
- [ ] RDS INSERT 后 10 秒内本地可见
- [ ] 无 OOM / 频繁 GC

全部通过后进入 [06-验证与排错.md](06-验证与排错.md) 做全链路压测和长期监控。
