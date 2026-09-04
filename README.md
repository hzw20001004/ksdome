# KsDome —— 可运行代码 Demo

> 本仓库已收敛为**纯代码仓库**：只保留可运行的 Spring Boot 示例模块。
> 原有的全部知识文档（数据库 / Docker / Linux / 命令手册等）已迁入 Obsidian 知识库
> `D:\xm\aw-xm\knowledge`（远端 gitee.com/hanzewei/knowledge），迁移说明见知识库
> `ksdome项目深度解读.md` 第九节「迁移记录」。

## 模块

| 模块 | 说明 |
|---|---|
| `Mybatis-puls` | MyBatis-Plus 二次封装范本：通用 CRUD 三层基座 + SQL 注入器批量插入 + 自动填充 |
| `Java8` | Lambda / Stream / Optional / 并行流 / 重复注解练习 |
| `rabbitMq-Mqtt` | Eclipse Paho MQTT 收发 demo（RabbitMQ MQTT 插件接入） |

## 非模块目录

| 目录 | 说明 |
|---|---|
| `Utils/` | 散装工具类：数据脱敏三件套、Redisson 锁封装、Stream 建树、IP 归属地 |
| `钉钉/` | 钉钉机器人加签发送样例（凭证已脱敏，使用前替换为自己的 token） |
| `私有开发项目文档/` | 内网项目端口规划（敏感，勿推共享远端） |
| `部署/` | start.sh / test.vbs 启动脚本 |

## 构建

```shell
mvn clean package -pl Mybatis-puls,Java8,rabbitMq-Mqtt
```
