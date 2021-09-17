#Docker   常用命令

##docker 命令
```shell

docker run -it 镜像名 /bin/bash         (运行容器)
exit 或者 Ctrl+P+Q                      (退出容器不停止)
docker images                          (查询全部容器的信息)
docker ps -a                           (查看容器) 
docker ps                              (查看当前所有运行容器)
docker inspect 3f7d139292ea            (查看容器的信息,3f7d139292ea 为镜像名)
docker rm 镜像名                        (删除镜像)
docker rm -f $(docker ps -aq)          (清空所有的镜像)
docker rmi -f $(docker images -aq)     (强制删除本地镜像)
docker network ls                      (查看docker所有网络)
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




















































