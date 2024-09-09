# Sql 基础语法 Dome

>创建数据库
```sql
-- 创建数据库
create tablespace TICKET datafile '/home/oracle/TICKET2.dbf'
    size 512M autoextend on next 24M permanent online;
-- 创建用户  绑定数据库
create user TICKET identified by 123456 default tablespace TICKET;
-- 直接赋予dba权限，或者自定义权限
grant dba to TICKET;

-- oracle导入 dbf文件
imp TICKET/123456@127.0.0.1/XE file=/home/oracle/TICKET1.dbf full=yes tablespaces=TICKET

```
























