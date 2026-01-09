# Sql 基础语法 Dome

>创建数据库
```sql
-- 创建数据库
create tablespace STATION datafile '/home/oracle/STATION.dbf'
    size 512M autoextend on next 24M permanent online;
-- 创建用户  绑定数据库
create user STATION identified by 123456 default tablespace STATION;
-- 直接赋予dba权限，或者自定义权限
grant dba to STATION;

-- 拷贝进容器
docker cp /home/STATION.dmp e78f1f82309a:/home/oracle/STATION.dmp
-- oracle导入 dbf文件
imp STATION/123456@127.0.0.1/XE file=/home/oracle/STATION.dmp full=yes tablespaces=STATION

```













