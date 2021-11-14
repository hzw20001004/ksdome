#Docker   常用命令

##docker 命令
```shell

docker run -it 镜像名 /bin/bash         (运行容器)
exit 或者 Ctrl+P+Q                      (退出容器不停止)
docker images                          (查询全部容器的信息)
docker ps -a                           (查看容器) 
docker stop 镜像名                      (停止容器) 
docker ps                              (查看当前所有运行容器)
docker inspect 3f7d139292ea            (查看容器的信息,3f7d139292ea 为镜像名)
docker rm 镜像名                        (删除镜像)
docker rm -f $(docker ps -aq)          (清空所有的镜像)
docker rmi -f $(docker images -aq)     (强制删除本地镜像)
docker network ls                      (查看docker所有网络)
systemctl enable docker                (把docker设置为自启动)
docker start 59ec(镜像CONTAINER ID)     (启动一个已经启动过的镜像) 
docker restart mysql                   (重启容器)
docker update redis --restart=always   (容器随docker启动自动运行)
docker exec -it 4ade58503598 /bin/bash (进入容器后开启一个新的终端,可以在里面操作  "常用" )
```
### Docker File 命令
```shell
FROM          # 基础镜像,一切从这里开始构建
MAINTAINER    #镜像是谁写的,一般格式为: 姓名+邮箱
RUN           #镜像构建的时候需要运行的命令
ADD           #步骤,tomcat镜像,这个tomcat压缩包 ! 添加内容
WORKDIR       #挂载的目录
EXPOST        #保留端口配置
CMD           #指定这个容器启动的时候运行的命令，只有最后一个会生效,可被替代
ENTTRYPOINT   #指定这个容器启动的时候要运行的命令,可以追加命令
NOBUILD       #当构建一个被继承DockerFile 这个时候就会运行NOBUILD的指令。触发指令。
COPY          #类似ADD,将我们的文件拷贝到镜像中
ENY           #构建的时候设置环境变量!
```


##阿里云镜像加速
```shell
# 创建文件
sudo mkdir -p /etc/docker
# 修改配置, 设置镜像
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://vw9qapdy.mirror.aliyuncs.com"]
}
EOF
# 重启后台线程
sudo systemctl daemon-reload
# 重启docker
sudo systemctl restart docker
```

##mysql 启动 和 配置
```shell
docker 上 拉取mysql
sudo docker pull mysql:8.0
启动mysql
docker run -p 3306:3306 --name mysql8 -v /usr/mydata/mysql/log:/var/log/mysql -v /usr/mydata/mysql/data:/var/lib/mysql -v /usr/mydata/mysql/conf:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0



1. 进入挂载的mysql配置目录
cd usr/mydata/mysql/conf    根据自己挂载路径来

2. 修改配置文件 my.cnf
vi my.cnf
加入内容
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
init_connect='SET collation_connection = utf8_unicode_ci'
init_connect='SET NAMES utf8'
character-set-server=utf8
collation-server=utf8_unicode_ci
skip-character-set-client-handshake
skip-name-resolve

3. docker重启mysql使配置生效
docker restart mysql8

4.容器随docker启动自动运行
# mysql
docker update mysql8 --restart=always
```
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












```shell
# 创建redis 集群
# 创建reids网卡
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker network create redis --subnet 127.38.0.0/16
d21a529198a5e63d221786094bd6056b6a96b86d774d6f5df48fd39ff0e76293
# 通过脚本创建 6个redis 配置
for port in $(seq 1 6); \     #循环创建6个reids
do \
mkdir -p /mydata/redis/node-${port}/conf    #创建reids配置文件
touch /mydata/redis/node-${port}/conf/redis.conf
cat << EOF >/mydata/redis/node-${port}/conf/redis.conf
port 6379      # reids端口
bind 0.0.0.0
cluster-enabled yes    # 开启这个redis 容器
cluster-config-file nodes.conf
cluster-node-timeout 5000
cluster-announce-ip 172.38.0.1${port}
cluster-announce-port 6379
cluster-announce-bus-port 16379
appendonly yes
EOF
done 
# 启动reids
docker run -p 6371:6379 -p 16371/16379 --name redis-1 \ 
-v /mydata/redis/node-1/data:/data \
-v /mydata/reids/node-1/conf/redis.conf:/etc/reids/reids.conf \
-d --net reids --ip 172.38.0.11 redis:5.0.9-alpine3.11 redis-server /etc/reids/redis.conf; \

```



```shell
for port in $(seq 1 6); \   
do \
docker run -p 637${port}:6379 -p 1637${port}/16379 --name redis-${port} \ 
-v /mydata/redis/node-${port}/data:/data \ 
-v /mydata/reids/node-${port}/conf/redis.conf:/etc/reids/reids.conf \ 
-d --net reids --ip 172.38.0.1${port} redis:5.0.9-alpine3.11 redis-server /etc/reids/redis.conf; \
done

```
命令有问题


##SpringBoot 放到docker里跑起来
















docker run -d \
-e PREFER_HOST_MODE=hostname \
-e MODE=cluster \
-e NACOS_SERVER_PORT=3333 \
-e NACOS_SERVERS="121.199.39.50:3333 121.199.39.50:4444 121.199.39.50:5555" \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=121.199.39.50 \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=nacos \
-e NACOS_SERVER_IP=121.199.39.50 \
-p 3333:3333 \
--name my-nacos1 \
nacos/nacos-server:1.4.2

docker run -d \
-e PREFER_HOST_MODE=hostname \
-e MODE=cluster \
-e NACOS_SERVER_PORT=4444 \
-e NACOS_SERVERS="121.199.39.50:3333 121.199.39.50:4444 121.199.39.50:5555" \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=121.199.39.50 \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=nacos \
-e NACOS_SERVER_IP=121.199.39.50 \
-p 4444:4444 \
--name my-nacos2 \
nacos/nacos-server:1.4.2


docker run -d \
-e PREFER_HOST_MODE=hostname \
-e MODE=cluster \
-e NACOS_SERVER_PORT=5555 \
-e NACOS_SERVERS="121.199.39.50:3333 121.199.39.50:4444 121.199.39.50:5555" \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=121.199.39.50 \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=nacos \
-e NACOS_SERVER_IP=121.199.39.50 \
-p 5555:5555 \
--name my-nacos3 \
nacos/nacos-server:1.4.2













