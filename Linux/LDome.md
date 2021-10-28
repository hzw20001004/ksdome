#Linux   常用命令和知识

##命令

###基础操作命令
```shell
source /etc/profile                                             #重启环境 生效命令
--help                                                          #查看使用命令
mkdir dockerfile                                                #创建文件夹
ip addr                                                         #获取当前IP地址
ping -c4 192.168.0.5                                            #ping语法 解决ping端口停不了
```

###操作文件命令
```shell
vim dockerfile01 (打开编辑文件)
cat dockerfile01 (打开查看文件内容)
首先按ESC进入Command模式,然后输入:":wq",回车就可以保存并退出了   (命令前面冒号":"是必要的)
:w 保存文件但不退出vi

:w file 将修改另外保存到file中,不退出vi

:w! 强制保存,不推出vi

:wq 保存文件并退出vi

:wq! 强制保存文件,并退出vi

:q 不保存文件,退出vi

:q! 不保存文件,强制退出vi

:e! 放弃所有修改,从上次保存文件开始再编辑
```


























docker run -d \
-e PREFER_HOST_MODE=hostname \
-e MODE=cluster \
-e NACOS_SERVER_PORT=8846 \
-e NACOS_SERVERS="192.168.0.1:3333 192.168.0.1:4444 192.168.0.1:5555" \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=192.168.1.131 \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=nacos_config \
-e NACOS_SERVER_IP=192.168.1.131 \
-p 8846:8846 \
--name my-nacos1 \
nacos/nacos-server:1.4.2











