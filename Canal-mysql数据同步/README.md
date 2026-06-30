# Canal 部署归档 (jielong 实例)

> 归档时间：2026-06-30
> 归档范围：阿里云 RDS `jielong` 库 → 本地 MySQL 的全链路 Canal 同步部署
> Canal 版本：v1.1.5 (canal-server + canal-adapter，独立模式，不依赖 canal-admin)

---

## 一、用途

本目录是这次 Canal 部署的完整快照，包含：

- 全部配置文件（canal-server / canal-adapter）
- 两个 docker-compose 编排（Canal 套件 + MySQL）
- 一套分阶段的部署文档（带执行步骤）

用途场景：

1. **重装/迁移**：换机器或换网段时，按文档 02→05 顺序执行即可重建。
2. **回滚参考**：线上配置改坏后，对照本目录恢复。
3. **交接资料**：新人接手时按文档通读一遍即可理解整套同步链路。

---

## 二、目录结构

```
backup-sigx_zmn/
├── README.md                                    # 本文件（入口索引）
├── 01-架构与数据流.md                            # 数据流向、组件、端口
├── 02-环境准备.md                                # 主机/目录/mount/网络
├── 03-部署MySQL.md                              # sig-mysql-txg 目标库
├── 04-部署Canal-Server.md                       # 拉 RDS binlog
├── 05-部署Canal-Adapter.md                      # 写入本地 MySQL
├── 06-验证与排错.md                              # 全链路验证、常见错误
├── canal-server-conf/                           # Canal-Server 配置
│   ├── canal.properties                         # 全局配置
│   ├── jielong-instance.properties              # 实例配置（RDS 连接 + 解析并行）
│   ├── logback.xml                              # 日志策略（5MB/天/30天/20GB）
│   └── 数据库.md                                # RDS 加列脚本（__#alibaba_rds_row_id#__）
├── canal-adapter-conf/                          # Canal-Adapter 配置
│   ├── application.yml                          # 全局 + 数据源 + 适配器
│   └── rdb/
│       └── jielong.yml                          # 镜像库映射（mirrorDb: true）
├── docker-compose-dev测试-Canal+CanalAdmin-优化.yml  # canal-server + canal-adapter 编排
└── docker-compose-dev测试-mysql优化.yml              # sig-mysql-txg 目标库编排
```

---

## 三、文档导航（按阅读顺序）

| 顺序 | 文档 | 看完能回答 |
|---|---|---|
| 1 | [01-架构与数据流.md](01-架构与数据流.md) | 数据从哪到哪？涉及哪些组件？端口怎么规划？ |
| 2 | [02-环境准备.md](02-环境准备.md) | 上服务器第一件事做什么？目录怎么建？文件放哪？ |
| 3 | [03-部署MySQL.md](03-部署MySQL.md) | 目标库怎么起？关键参数有哪些？ |
| 4 | [04-部署Canal-Server.md](04-部署Canal-Server.md) | RDS 要开什么？server 怎么连 RDS？ |
| 5 | [05-部署Canal-Adapter.md](05-部署Canal-Adapter.md) | adapter 怎么接 server？怎么写目标库？ |
| 6 | [06-验证与排错.md](06-验证与排错.md) | 怎么确认整条链路通？出错看哪里？ |

---

## 四、快速开始（已熟悉环境时）

```bash
# 1. 上传本目录所有文件到部署机 /home/canal/ 与 /home/txg/mysql/
#    详细路径见 02-环境准备.md

# 2. 启动目标 MySQL
docker compose -f docker-compose-dev测试-mysql优化.yml up -d

# 3. RDS 侧加 __#alibaba_rds_row_id#__ 列（见 canal-server-conf/数据库.md）

# 4. 启动 Canal-Server + Canal-Adapter
docker compose -f docker-compose-dev测试-Canal+CanalAdmin-优化.yml up -d

# 5. 在 RDS jielong 库做一条 INSERT，本地 jielong 库秒级同步到 → 链路通
```

---

## 五、关键参数速查

| 参数 | 值 | 出处 | 备注 |
|---|---|---|---|
| RDS 地址 | `rm-bp1c2x3191qxo5o7x8o.mysql.rds.aliyuncs.com:3306` | application.yml / jielong-instance.properties | 阿里云 RDS 源库 |
| RDS 账号 | `systemdba` | 同上 | — |
| 本地目标库 | `sig-mysql-txg:3306` | application.yml | docker 内部服务名 |
| 目标库账号 | `root / Aw123456.` | application.yml | — |
| Canal-Server 端口 | `11111`（数据）/ `11112`（metrics） | canal.properties | — |
| Canal-Adapter 端口 | `8081` | application.yml | REST 接口 |
| 实例名 | `jielong` | jielong-instance.properties | 镜像整个 `jielong` 库 |
| 同步模式 | `mirrorDb: true` | rdb/jielong.yml | 整库镜像，不挑表 |

---

## 六、本次调优要点（详见 [06-验证与排错.md](06-验证与排错.md)）

- `syncBatchSize: 5000`（原 1000），`canal.tcp.batch.size: 2000`（原 500）—— 提升批量
- `threads: 20`（原 5）—— adapter 写入并发，吃满 32 核机器
- `parallelBufferSize: 512`（默认 256）—— 必须是 2 的幂
- `parallelThreadSize` **不要显式设**，源码 fallback 自动算 60% 核心数
- `rewriteBatchedStatements=true` —— JDBC 合并 INSERT，批量写入利器
- JVM 堆 `-Xms4g -Xmx4g`（canal-server 默认 2G 偏小）
- logback 用 1.1.3 老语法（`TimeBasedRollingPolicy` + `SizeAndTimeBasedFNATP`），不要用 `SizeAndTimeBasedRollingPolicy`

---

## 七、归档时主机原貌（仅参考，实际以宿主机为准）

| 项 | 值 |
|---|---|
| 部署根目录 | `/home/canal/`（canal 套件）/ `/home/txg/mysql/`（目标库） |
| 主机规格（目标库机） | 62G 内存 / 16 核 / 113G 磁盘 |
| 主机规格（canal 机） | 64G 内存 / 32 核 |
| Docker Compose 版本 | v2.x（`docker compose` 子命令形式） |
