#Docker   常用命令和知识

##docker 命令
```shell
docker run -it 镜像名 /bin/bash (运行容器)
exit 或者 Ctrl+P+Q(退出容器不停止)
docker images (查询全部容器的信息)
docker ps -a (查看容器)
docker ps (查看当前所有运行容器)
docker inspect 3f7d139292ea(查看容器的信息,3f7d139292ea 为镜像名)

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
![img.png](img.png)
```shell
#启动下自己写的容器
```
![img_1.png](img_1.png)
```shell
这卷和外部一定有一个同步的目录
```
![img_2.png](img_2.png)
```shell
查看一下卷挂载的路径
```
![img_3.png](img_3.png)
```shell
验证一下文件是否同步出去了
这种方式未来使用的十分多,因为我们通常会构建自己的镜像
假设构建镜像的时候没有挂载卷,要手动自动挂载 -v 卷名 容器内路径!
```
![img_4.png](img_4.png)
##数据卷容器
```shell
多个MySQL同步数据
```
![img_5.png](img_5.png)
```shell
# 启动3个容器进行测试, 通过刚刚自己的写的镜像启动
```
![img_6.png](img_6.png)
![img_8.png](img_8.png)
![img_7.png](img_7.png)
![img_9.png](img_9.png)
![img_10.png](img_10.png)
```shell
得出结论,相互共享的容器,删除其中任何一个容器,不影响其他容器数据
```




















































