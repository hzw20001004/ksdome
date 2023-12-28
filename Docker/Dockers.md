#Docker   常用命令

##docker 命令
```shell
启动        systemctl start docker
更新配置     sudo systemctl daemon-reload
重启docker服务   systemctl restart  docker
重启docker服务  sudo service docker restart
关闭docker   service docker stop   
关闭docker  systemctl stop docker
更新配置 并 重启docker systemctl daemon-reload && systemctl restart docker
#这二个命令是一起用的
停用Docker自动唤醒机制  systemctl stop docker.socket
查看Docker自动唤醒机制是否关闭  systemctl status docker

```


##docker 容器 命令
```shell

docker run -it 镜像名 /bin/bash         (运行容器)
exit 或者 Ctrl+P+Q                      (退出容器不停止)
docker images                          (查询全部容器的信息)
docker ps -a                           (查看容器) 
docker stop 镜像名                      (停止容器) 
docker ps                              (查看当前所有运行容器)
docker inspect 3f7d139292ea            (查看容器的信息,3f7d139292ea 为镜像名)
docker rm 镜像名                        (删除镜像)
docker rmi 镜像名                        (删除images镜像)
docker rm -f $(docker ps -aq)          (清空所有的镜像)
docker rmi -f $(docker images -aq)     (强制删除本地镜像)
docker network ls                      (查看docker所有网络)
systemctl enable docker                (把docker设置为自启动)
docker start 59ec(镜像CONTAINER ID)     (启动一个已经启动过的镜像) 
docker restart mysql                   (重启容器)
docker update redis --restart=always   (容器随docker启动自动运行)
docker exec -it c5a715a1c74b /bin/bash (进入容器后开启一个新的终端,可以在里面操作  "常用" )
容器内部安装vim命令
apt-get update
apt-get install vim
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

### Docker 内外文件拷贝
```shell
docker cp 容器ID:容器内文件路径 宿主机路径

docker cp 宿主机文件路径 容器ID:容器内文件路径

docker cp /mydata/sql c5a715a1c74b:/sql
```







docker cp /mydata 768de823c49f:/home/sigx_cps.sql













