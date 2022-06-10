##Redis操作 Dome 

Redis 官网：https://redis.io/
###Docker安装redis
```shell
##redis 启动 和 配置
```shell
1.docker 拉取 redis
docker pull redis

2.docker启动redis
因为没有 redis.conf文件, 得先创建文件夹 再进行启动挂载
mkdir -p /mydata/redis/conf
touch /mydata/redis/conf/redis.conf
启动redis 命令
docker run -p 6379:6379 --name redis \
-v /mydata/redis/data:/data \
-v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf \
-d redis redis-server /etc/redis/redis.conf

3.redis 持久化配置
echo "appendonly yes"  >> /mydata/redis/conf/redis.conf
# 重启生效
docker restart redis

4.容器随docker启动自动运行
# redis
docker update redis --restart=always
```

###redis 5大数据结构
```shell
String: 字符串 String
  应用程序场景：非常常见的场景用于计算站点访问量、当前在线人数等。incr命令(++操作)
  
Hash: 散列 Hashmap
  应用场景：存储部分更改数据，如用户信息、会话共享 用于内容不变更的内容存储
  
List: 列表 LinkList
  应用场景：不经常变更的数据进行分页  
  reids的链表结构，可以轻松实现阻塞队列，可以使用左进右出的命令组成来完成队列的设计。
  比如：数据的生产者可以通过Lpush命令从左边插入数据，多个数据消费者，可以使用BRpop命令阻塞的“抢”列表尾部的数据。
  
Set: 集合 HashSet
  应用场景：
  共同好友、二度好友 
  利用唯一性，可以统计访问网站的所有独立 IP 
  好友推荐的时候，根据 tag 求交集，大于某个 threshold 就可以推荐
  
Sorted Set: 有序集合 TreeSet
  应用场景：
  排行榜应用  
  学生的成绩大小
```
###


























































