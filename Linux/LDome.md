#Linux   常用命令和知识

###基础操作命令
```shell
su - root                                                       #切换用户
source /etc/profile                                             #重启环境 生效命令
--help                                                          #查看使用命令
mkdir dockerfile                                                #创建文件夹
ip addr                                                         #获取当前IP地址
ping -c4 192.168.0.5                                            #ping语法 解决ping端口停不了
/etc/init.d/bt default                                          #宝塔地址账号密码     
netstat -nltp | grep 9083  查看端口是否占用
kill -9 1321  杀端口  
touch frps.ini                                                  #创建文件 比vim好用 

对外开放端口 
查看想开的端口是否已开：firewall-cmd --query-port=6379/tcp
添加指定需要开放的端口：firewall-cmd --add-port=123/tcp --permanent
重载入添加的端口：firewall-cmd --reload
查询指定端口是否开启成功：firewall-cmd --query-port=123/tcp
移除指定端口：firewall-cmd --permanent --remove-port=123/tcp


```

###永久修改服务器名称

```shell
hostnamectl set-hostname brace #永久设置用户名，关机后不失效
hostname
brace
###进程操作
```
查看前10 项目内存情况
ps aux | sort -k4,4nr | head -n 10 
```



###操作tomcat
```shell
./allstartup.sh   杀死所有tomcat进程并重启
sh startup.sh  启动
sh shutdown.sh 停止

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

### Linux时间同步
```agsl
ntpdate ntp1.aliyun.com

service ntpd stop

ntpdate ntp1.aliyun.com

date
```


















