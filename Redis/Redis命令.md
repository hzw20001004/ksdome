##Redis操作 Dome
```text
如果你想要清空Redis服务器上所有数据库中的所有数据，可以使用FLUSHALL命令。
这个命令会清除所有数据库的所有数据，因此使用时需要格外小心。
redis-cli FLUSHALL

如果你想清空特定的数据库，可以使用-n选项来指定数据库编号（编号从0开始）：
redis-cli -n 1 FLUSHDB

登录
redis-cli
密码登录
redis-cli -a your_password

插入key
SET mykey "myvalue"
SET lottery:stock 1

删除key
DEL key 




```











































