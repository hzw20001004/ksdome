#Linux  常用软件安装

## Centos7安装Git
```shell
yum install -y git
返回版本号表示安装成功
```
## Centos7安装node
```shell
1. yum install wget -y  # 下载安装wget
2. wget https://nodejs.org/dist/v16.14.2/node-v16.14.2-linux-x64.tar.xz  # 下载 node.js 软件压缩包
3. tar -vxf node-v16.14.2-linux-x64.tar.xz   # 解压node.js软件压缩软件包
4. mv node-v16.14.2-linux-x64 /usr/local/bin  # 移动node到/usr/local/bin目录下
5. cd /usr/local/bin/  # 进入/usr/local/bin
6. ll  # 查看当前目录下的文件、目录
7. mv node-v16.14.2-linux-x64/ node  #修改node-v16.14.2-linux-x64 名称为 node
8. vi /etc/profile  # vi修改配置文件 添加node.j2软件环境变量
9. 加入内容
   export NODE_HOEM=/usr/local/bin/node  # 设置node软件家目录的环境变量
   export PATH=$PATH:$NODE_HOEM/bin      # 设置node软件到bin目录下环境变量  实现bin目录下命令的全局使用 
10. source /etc/profile   # 使配置文件生效
11. 查看node版本 
    node -v
12. 查看npm版本
    npm -v
```

服务器yum配置
安装JDK1.8
1.执行命令yum -y list java*查看可安装java版本。执行成功后可以看见如下的结果
2.执行命令yum install -y java-1.8.0-openjdk-devel.x86_64。执行完后会看见控制台刷出很多输出
3.输入java -version查看已安装的jdk版本，当出现如下输出表示安装成功。
4.你可能好奇，yum安装的jdk，被安装到哪里去了？你可以在/usr/lib/jvm目录下找到他们。

#安装tomcat9
1.安装wget   
yum install -y wget
2.检测是否安装成功
rpm -qa | grep wget
3.wget下载安装包
wget https://mirrors.cnnic.cn/apache/tomcat/tomcat-9/v9.0.50/bin/apache-tomcat-9.0.50.tar.gz
4.解压
tar -zxvf apache-tomcat-9.0.50.tar.gz -C /usr/local/tomcat     后面的路径为你想安装的地址
5.启动
#进入tomcat目录
cd /home/apache-tomcat-9.0.50
#启动tomcat
./bin/startup.sh
6.关闭防火墙
#关闭防火墙
systemctl stop firewalld
#查看防火墙状态
systemctl status firewalld
#关闭开机启动
systemctl disable firewalld
设置开机自启动
Tomcat添加启动参数
catalina.sh在执行的时候会调用同级路径下的setenv.sh来设置额外的环境变量，因此在/usr/local/tomcat/apache-tomcat-9.0.50/bin路径下创建setenv.sh文件，内容如下：
export CATALINA_HOME=/usr/local/tomcat/apache-tomcat-9.0.50
export CATALINA_BASE=/usr/local/tomcat/apache-tomcat-9.0.50
#设置Tomcat的PID文件
CATALINA_PID="$CATALINA_BASE/tomcat.pid"
#添加JVM选项
JAVA_OPTS="-server -XX:PermSize=256M -XX:MaxPermSize=1024m -Xms512M -Xmx1024M -XX:MaxNewSize=256m"

编写tomcat.service文件
在/usr/lib/systemd/system路径下添加tomcat.service文件，内容如下：

[Unit]
Description=Tomcat
After=syslog.target network.target remote-fs.target nss-lookup.target

[Service]
Type=forking
PIDFile=/usr/local/tomcat/apache-tomcat-9.0.50/tomcat.pid
ExecStart=/usr/local/tomcat/apache-tomcat-9.0.50/bin/startup.sh
ExecReload=/bin/kill -s HUP $MAINPID
ExecStop=/bin/kill -s QUIT $MAINPID
PrivateTmp=true

[Install]
WantedBy=multi-user.target

[unit]配置了服务的描述，规定了在network启动之后执行，
[service]配置服务的pid，服务的启动，停止，重启
[install]配置了使用用户

将Tomcat加入服务管理
systemctl enable tomcat.service
systemctl disable tomcat.service
systemctl start tomcat.service
systemctl stop tomcat.service
systemctl restart tomcat.service


安装mysql8

重点！！！
查看当前是否有安装mysql
find / -name mysql

若有安装，一定要清理干净！
rm -rf 路径

若安装MySQL后mysqld.log为空，则是因为之前安装的mysql有残留，所以得先清理当前安装的，再重复上面步骤，清理以前残留的mysql
rpm -qa|grep -i mysql

rpm -ev 包名

若报错，则执行下面语句

rpm -ev 包名 --nodeps


正式安装

1.安装yum mysql数据源命令：（中间需要输入两次 y ）
yum localinstall https://dev.mysql.com/get/mysql80-community-release-el7-1.noarch.rpm

2.安装mysql服务
yum 安装命令：（安装过程需要输入三次 y ，最后一次是证书）
yum install mysql-community-server

3.启动mysql服务
systemctl start mysqld
启动成功没有提示

4.获取初始化密码
获取命令：
cat /var/log/mysqld.log | grep password

5.登陆mysql
登陆命令：
mysql -u root -p

6.第六步：修改密码
ALTER USER 'root'@'localhost' IDENTIFIED BY 'yournewpassword';

mysql -u root -h 127.0.0.1 -p    本地连接  

备份数据库
mysqldump -u root -h 127.0.0.1 -p chengtou >/home/chengtou2022.2.9.sql


如果爆出 ERROR 1819 (HY000): Your password does not satisfy the current policy requirements 错误，原因是你的密码不安全，要包含大小写，数字和字符


可能出现的错误:
1.若阿里云上安装的mysql，发现用本地电脑的navicat链接不上。
博客地址:https://blog.csdn.net/iiiiiilikangshuai/article/details/100905996
mysql -u root -p   登录到mysql中。

use mysql;

select host from user where user='root';

修改帐号不允许从远程登陆，只能在localhost。这个时候只要在localhost的那台电脑，登入MySQL后，更改 "mysql" 数据库里的 "user" 表里的 "host" 项，从"localhost"改称"%"

update user set host = '%' where user ='root';

flush privileges;

2.navicat 连接不上虚拟机上的mysql容器 client does not support authentication protocol requested by server；
博客地址:https://blog.csdn.net/yubin1285570923/article/details/83352491

原因:navicat版本过低。



安装redis

https://www.cnblogs.com/hjw-zq/p/9778514.html

注:阿里云上得开启端口


nginx安装

LINUX安装nginx详细步骤
1.安装依赖包
//一键安装上面四个依赖
yum -y install gcc zlib zlib-devel pcre-devel openssl openssl-devel
2.下载并解压安装包
//创建一个文件夹
cd /usr/local
mkdir nginx
cd nginx
//下载tar包
wget http://nginx.org/download/nginx-1.13.7.tar.gz
tar -xvf nginx-1.13.7.tar.gz
3.安装nginx
//进入nginx目录
cd /usr/local/nginx
//进入目录
cd nginx-1.13.7
//执行命令
./configure
//执行make命令
make
//执行make install命令
make install
4.配置nginx.conf
5.启动nginx
1. # 启动nginx
2.  /usr/local/nginx/sbin/nginx -s reload

如果出现报错：nginx: [error] open() ＂/usr/local/nginx/logs/nginx.pid＂ failed

则运行： /usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf

再次启动即可！

3. #查看nginx进程是否启动

4.  ps -ef | grep nginx

nginx其他命令
启动，关闭，重启，命令：

./nginx 启动

./nginx -s stop 关闭

./nginx -s reload 重启













