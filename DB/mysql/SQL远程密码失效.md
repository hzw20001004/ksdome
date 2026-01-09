# Sql 远程密码失效

>用UPDATE直接编辑user表 
```text
mysql> use mysql; 
mysql> update user set password=password('123') where user='root' and host='localhost'; 
mysql> flush privileges; 
```

>windows
```text
1. 关闭正在运行的MySQL服务。 
2. 打开DOS窗口，转到mysql\bin目录。 
3. 输入mysqld --skip-grant-tables 回车。--skip-grant-tables 的意思是启动MySQL服务的时候跳过权限表认证。 
4. 再开一个DOS窗口（因为刚才那个DOS窗口已经不能动了），转到mysql\bin目录。 
5. 输入mysql回车，如果成功，将出现MySQL提示符 >。 
6. 连接权限数据库： use mysql; 。 
6. 改密码：update user set password=password("123") where user="root";（别忘了最后加分号） 。 
7. 刷新权限（必须步骤）：flush privileges;　。 
8. 退出 quit。 
9. 注销系统，再进入，使用用户名root和刚才设置的新密码123登录。
``` 

>开启远程访问权限(镜像里面 root用户已经有远程连接权限在里面，所以不需要去设置，只是模式不一样才导致无法连接，把root用户的密码改成 mysql_native_password 模式，即可远程连接)

```text
use mysql;
select host,user from user;
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root';
flush privileges;
```

>远程授权

```text
1. 先用localhost登录（进入MySQL）      mysql -u root -p
Enter password:  （输入密码）
2. 执行授权命令
mysql> grant all privileges on *.* to root@'%' identified by '123';  （注意语句后面的“；”）
mysql> grant all privileges on *.* to marketing@'%' identified by '123';  （注意语句后面的“；”）

Query OK, 0 rows affected (0.07 sec)
3. 退出再试：  mysql> quit
4、再试登录：    mysql -u root -h 192.168.194.142 -p
  Enter password: 
 结果显示：Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 3
表示成功
```

ALTER USER 'marketing'@'%' IDENTIFIED WITH mysql_native_password BY 'rMwbrNDZGMetN47n';
>指定用户的访问ip
```text
update user set host = '%' where user = 'root'; 
flush privileges;
```

> 8.0 改变登录身份验证 
```
# 查看当前的认证插件
select user,plugin from user where user='root';
# 更改该用户的加密方式
alter user 'marketing'@'localhost' identified with mysql_native_password by 'sigsoft';
alter user 'root'@'localhost' identified with mysql_native_password by 'sigsoft';
# 刷新生效
flush privileges;
```

> 修改访问权限

```text
CREATE USER 'root'@'%' identified by 'root';
GRANT ALL PRIVILEGES ON *.* to 'root'@'%';

FLUSH PRIVILEGES;


```









