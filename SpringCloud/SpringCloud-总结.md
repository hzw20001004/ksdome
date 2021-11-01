# Spring Cloud 基础简单总结
```shell
服务注册中心    (Eureka Zookeeper Consul Nacos(阿里))
Eureka        是一个AP  服务注册和发现组件 主要用于 服务的自动注册、发现、状态监控
Consul        是一个CP  服务注册和发现组件 主要用于 服务发现、健康检查、K-V存储、多数据中心
Nacos         是一个支持 AP 和 CP 模式的切换
              主要用于 构建云原生应用的动态服务发现、配置管理和服务管理平台。
服务调用       (Ribbon LoadBalancer)
Ribbon        主要用于 提供客户端的软件负载均衡算法 
              为消费者调用生产者提供负载均衡算法 
服务调用2      (Feign OpenFeign)
OpenFeign     主要用于 负载均衡并调用其他服务(ribbon+restTemplate)
服务降级       (Hystrix resilience4j Sentienl(阿里))
Hystrix       主要用于 保护系统间的调用延时以及错误，特别是通过第三方的工具的网络调用
                      阻止错误在分布式系统之前的传播
                      快速失败和迅速恢复
                      错误回退和优雅的服务降级 
Sentienl      主要用于 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度来帮助您保护服务的稳定性
服务网关       (Zuul Zuul2 Gateway)  
Zuul          主要用于 动态路由，监控，弹性，安全等边缘服务
Gateway       主要用于  身份验证和授权,请求聚合,服务发现集成,重试策略、断路器，
                       处理部分故障,IP 允许列表,协议转换,日志
服务配置       (Config Nacos(阿里))
Config        主要用于 配置管理
服务总线       (Nacos(阿里))
```





















































































