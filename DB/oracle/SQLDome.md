# Sql 基础语法 Dome
# 进入容器
docker exec -it oracle-xe bash
# 切换oracle用户
su oracle
# 本地登录，容器内部不用密码，操作系统认证
sqlplus / as sysdba
-- 修改system密码，11g注意：密码尽量不要特殊符号，大小写敏感
ALTER USER system IDENTIFIED BY oracle123;
-- 同时可以改sys密码
ALTER USER sys IDENTIFIED BY oracle123;
-- 解锁账号（防止账号被锁）
ALTER USER system ACCOUNT UNLOCK;
ALTER USER sys ACCOUNT UNLOCK;
commit;


>创建数据库
```sql
-- 1. 切换到【业务数据库】XEPDB1（必须先切！不然建到系统库去了）
ALTER SESSION SET CONTAINER = XEPDB1;

-- 2. 创建一个叫 jczl 的【存储空间】，用来放业务表、数据
create tablespace jczl
-- 数据文件存在这个路径（Oracle规定必须放在PDB目录下）
    datafile '/opt/oracle/oradata/XE/XEPDB1/jczl.dbf'
-- 初始大小 512MB
size 512M 
-- 空间不够自动扩容
autoextend on 
-- 每次自动扩容 48MB
next 48M 
-- 永久存储（存业务表用，默认就是这个）
permanent 
-- 创建后立即可以使用
online;

-- 3. 创建【数据库账号】：账号名 jczl，密码 *******
-- 默认把数据存到刚才创建的 jczl 表空间里
create user jczl identified by ******* default tablespace jczl;

-- 4. 给账号授权 DBA 权限（最高权限，开发/测试随便用）
grant dba to jczl;

-- 5. 给基础连接权限（必须加，不然账号登不上数据库）
grant connect, resource to jczl;

-- 拷贝进容器
docker cp /home/STATION.dmp e78f1f82309a:/home/oracle/STATION.dmp
-- oracle导入 dbf文件
imp jczl/*******@127.0.0.1/XE file=/home/oracle/STATION.dmp full=yes tablespaces=STATION



```

 











