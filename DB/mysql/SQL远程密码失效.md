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

>远程授权

```text
1. 先用localhost登录（进入MySQL）      mysql -u root -p
Enter password:  （输入密码）
2. 执行授权命令
mysql> grant all privileges on *.* to root@'%' identified by '123';  （注意语句后面的“；”）
Query OK, 0 rows affected (0.07 sec)
3. 退出再试：  mysql> quit
4、再试登录：    mysql -u root -h 192.168.194.142 -p
  Enter password: 
 结果显示：Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 3
表示成功
```

































