#Docker   常用的知识



##安装docker
```shell
安装命令
yum install docker
启动docker
service docker start 
查看版本 验证是否安装成功
docker version
设置开机自启
sudo systemctl enable docker
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
docker run -p 3300:3300 --name mysql8 -v /usr/mydata/mysql/log:/var/log/mysql -v /usr/mydata/mysql/data:/var/lib/mysql -v /usr/mydata/mysql/conf:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0



1. 进入挂载的mysql配置目录
cd /usr/mydata/mysql/conf    根据自己挂载路径来

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

5.外部连接不上mysql

进入mysql容器，并登陆mysql:
docker exec -it mysqlserver bash
mysql -uroot -p

开启远程访问权限(镜像里面 root用户已经有远程连接权限在里面，所以不需要去设置，只是模式不一样才导致无法连接，把root用户的密码改成 mysql_native_password 模式，即可远程连接)
use mysql;
select host,user from user;
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root';
flush privileges;

登录MySQL并查看端口号,如下图(若查出来的端口号是自己配置的mysql端口号，证明端口设置成功，无需往下看)
show global variables like 'port';

打开文件my.cnf,然后增加端口参数，设定端口
vim etc/mysql/my.cnf
加入内容
port=启动时设置的端口




mysql安装vim命令
apt-get update
apt-get install vim

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

##mongoDB 启动配置
```shell
1. 拉取 mongoDB 镜像
   docker pull mongo
2. 启动 mongoDB
   docker run -itd --name mongo -p 27017:27017 mongo --auth
-p 27017:27017 : 映射容器服务的 27017 端口到宿主机的 27017 端口
   外部可以直接通过 宿主机 ip:27017 访问到 mongo 的服务
--auth:需要密码才能访问容器服务
3. 进入mongo admin库
   docker exec -it mongo  mongo admin
4. 创建一个名为 root 密码为 1417的用户
   db.createUser({ user:'root',pwd:'140017',roles:[ { role:'userAdminAnyDatabase', db: 'admin'}]});
5. 确认用户是否安装成功
   db.auth('root','140017')
6. 角色权限
Read：允许用户读取指定数据库
readWrite：允许用户读写指定数据库
dbAdmin：允许用户在指定数据库中执行管理函数，如索引创建、删除，查看统计或访问system.profile
userAdmin：允许用户向system.users集合写入，可以找指定数据库里创建、删除和管理用户
clusterAdmin：只在admin数据库中可用，赋予用户所有分片和复制集相关函数的管理权限。
readAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读权限
readWriteAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读写权限
userAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的userAdmin权限
dbAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的dbAdmin权限。
root：只在admin数据库中可用。超级账号，超级权限
7. idea创建连接 
```

## ElasticSearch
```shell
1. 拉取 ElasticSearch
   docker pull elasticsearch:7.7.0
2. 启动 ElasticSearch 容器
   docker run --name elasticsearch -d -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -e "discovery.type=single-node" -p 9200:9200 -p 9300:9300 elasticsearch:7.7.0
3. 外网ip + 9200 确认是否能看到版本号
```
## Sentinel
```shell
1. 拉取 Sentinel
docker pull bladex/sentinel-dashboard
2. 启动 Sentinel 容器
   docker run --restart always  --name sentinel  -d -p 8858:8858 -d  bladex/sentinel-dashboard:latest
3. 外网ip + 8858 确认是否能到登录页

```



## Nacos
```shell
1. 拉取 Nacos
   docker pull nacos/nacos-server
2. 启动命令  数据库配置自己调整
docker run -d \
-e PREFER_HOST_MODE=hostname \
-e MODE=standalone \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=121.199.39.50 \
-e MYSQL_SERVICE_PORT=3300 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=nacos_config \
-e JVM_XMS=256m \
-e JVM_XMX=256m \
-p 8848:8848 \
--name myNacos \
--restart=always \
nacos/nacos-server
3. 访问 ip+ 8848/nacos
```

## Portainer
```shell
1. 拉取 Portainer
   docker pull lihaixin/portainer
2. 启动命令 Portainer
docker run -d -p 9000:9000 --restart=always \
-v /var/run/docker.sock:/var/run/docker.sock \
--name portainer lihaixin/portainer
3. 访问 ip+ 9000
```

##  Jenkins
```shell
1. 拉取 Jenkins
   docker pull jenkins/jenkins
   docker pull jenkins/jenkins:latest-jdk8
2. 创建 Jenkins 挂载目录
   mkdir -p /usr/local/jenkins
   chmod 777 /usr/local/jenkins   
   注意： 创建挂载目录的同时要给该目录配置权限 777，
    如果权限不足的话，到时进行目录挂载的时候会失败导致无法启动 Jenkins 容器。
3. 启动命令 Jenkins
   docker run -d \
    -p 8888:8080 \
    -p 50000:50000 \
    -v /usr/local/jenkins:/var/jenkins_home \
    -v /etc/localtime:/etc/localtime \
    --restart=always \
    --name=jenkins \
    jenkins/jenkins
3. 访问 ip+ 9000

4. 获取初始登录密码 docker logs jenkins   18edf62f870d479aad883c987b169a1c

```
## Nginx
```shell
1. 拉取 Nginx
   docker pull nginx
2. 创建挂载目录
   mkdir -p /home/nginx/conf
   mkdir -p /home/nginx/log
   mkdir -p /home/nginx/html
3. 启动命令 Nginx
   docker run \
   -p 9002:80 \
   --name nginx \
   -v /home/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
   -v /home/nginx/conf/conf.d:/etc/nginx/conf.d \
   -v /home/nginx/log:/var/log/nginx \
   -v /home/nginx/html:/usr/share/nginx/html \
   -d nginx:latest
4. 
   
   
       curl https://dockeraw:2345/info --cert /data/cert/docker/cert.pem --key /data/cert/docker/key.pem --cacert /data/cert/docker/ca.pem
       curl https://101.34.67.170:2345/info --cert /data/cert/docker/cert.pem --key /data/cert/docker/key.pem --cacert /data/cert/docker/ca.pem
    
    
    
   
   
   server {
        listen     80;
        server_name  localhost;

        location / {
            root /usr/share/nginx/html; # nginx工作目录是容器的而非宿主机
            index index.html index.htm;
	}
        # 代理转发请求至网关，prod-api标识解决跨域问题
        location /dockeraw/ {
            proxy_pass https://dockeraw:2345/info;
	}
    }
   
   
   
   
   
   
```










##初始Dockerfile
```shell
# Dockerfile 就是用来构建docker镜像的构建文件！ 脚本命令 
# 通过这个脚本可以生成镜像,镜像一层一层的，脚本是一个个的命令,每个命令都是一层;
```
```shell
# 创建一个dockerfile文件，名字可以自己取，
# 文件中的内容
FROM centos

VOLUME ["volume01","volume02"]

CMD echo "----cgcg----"

CMD /bin/bash

# 上面每个命令都是镜像的一层.
```
![img.png](img/img.png)
```shell
#启动下自己写的容器
```
![img_1.png](img/img_1.png)
```shell
这卷和外部一定有一个同步的目录
```
![img_2.png](img/img_2.png)
```shell
查看一下卷挂载的路径
```
![img_3.png](img/img_3.png)
```shell
验证一下文件是否同步出去了
这种方式未来使用的十分多,因为我们通常会构建自己的镜像
假设构建镜像的时候没有挂载卷,要手动自动挂载 -v 卷名 容器内路径!
```
![img_4.png](img/img_4.png)
##数据卷容器
```shell
多个MySQL同步数据
```
![img_5.png](img/img_5.png)
```shell
# 启动3个容器进行测试, 通过刚刚自己的写的镜像启动
```
![img_6.png](img/img_6.png)
![img_8.png](img/img_8.png)
![img_7.png](img/img_7.png)
![img_9.png](img/img_9.png)
![img_10.png](img/img_10.png)
```shell
得出结论,相互共享的容器,删除其中任何一个容器,不影响其他容器数据
```
>DockerFile

###dockerFile 是用来构建docker镜像的文件！ 命令参数脚本！
```shell
1.编写一个docker文件
2.docker build 构建成为一个镜像
3.docker run 运行镜像
4.docker push 发布镜像 (发布到DockerHub 阿里云镜像仓库!)
```
###查看官方是怎么做镜像的？
![img_11.png](img/img_11.png)
![img_12.png](img/img_12.png)
###很多官方镜像都是基础包,很多功能都不是很完善,我们通常会自己搭建自己的镜像!
###官方既然可以做镜像，那我们也可以做一个属于自己的镜像!
>DockerFile 构建过程

```shell
基础知识
1.每个保留关键字(指令)都是必须是大写字母
2.执行从上到下顺序执行
3.# 表示注释
4.每个指令都会生成新的镜像层,并提交!
```
![img_13.png](img/img_13.png)
```shell
dockerfile都是面向开发的,我们以后要发布项目,就需要编写dockerfile文件,这个文件十分简单
以前交付  jar war
现在交付  Docker镜像 
Docker镜像逐渐成为企业交付的标准,必须要掌握!
Docker images: 通过Docker File 构建生成的镜像,最终发布和运行的产品!
Docker容器:容器就是镜像运行起来提供服务器
```
>DockerFile 的指令

以前的话我们是使用别人的，现在我们知道了这些指令后，我们来练习自己写一个镜像！
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
![img_14.png](img/img_14.png)
>实战测试





>镜像云镜像服务上

1.登录到阿里云
2.找到容器镜像服务
3.创建命名空间
4.创建容器镜像
![img_19.png](img/img_19.png)
5.镜像推送到阿里云的的镜像仓库
```shell
# 登录
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker login --username=迷人酥酥 registry.cn-hangzhou.aliyuncs.com
Password: 
WARNING! Your password will be stored unencrypted in /root/.docker/config.json.
Configure a credential helper to remove this warning. See
https://docs.docker.com/engine/reference/commandline/login/#credentials-store
Login Succeeded
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker images
REPOSITORY               TAG       IMAGE ID       CREATED        SIZE
hzw/tomcat               1.5       fb16eb6c7c09   11 hours ago   545MB
hzw20001004/tomcat8080   1.5       fb16eb6c7c09   11 hours ago   545MB
diytomcat8080            latest    fb16eb6c7c09   11 hours ago   545MB
[root@iZbp1bjhiosovua6v1vsclZ ~]# docker push hzw20001004/tomcat8080:1.5
```
具体操作到阿里云官网看看

##小结
![img_20.png](img/img_20.png)
![img_21.png](img/img_21.png)



































