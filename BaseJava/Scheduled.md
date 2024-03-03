# Scheduled 定时任务函数

```text
//早晚12点执行一次
//@Scheduled(cron = "0 0 0,12 * * ?")
//一分钟执行一次
//@Scheduled(cron = "0 */1 * * * ?")
```
