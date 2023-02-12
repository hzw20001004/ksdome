# Sql 基础命令脚本

>数据库操作
```sql
-- 进入数据库内部
mysql -h 127.0.0.1 -P 3300 -u root -p

-- 执行sql脚本
source /home/20220221.sql

-- docker容器外 执行sql脚本
docker exec -i ba46824c3dd2 mysql -uroot -pHzw20011004. jinlangtou < /mydata/jinlangtou.sql;

-- 导出指定数据库 并指定导出位置
mysqldump -h 127.0.0.1 -u root -p chengtou > /home/20220221.sql

```





































