# Sql 基础命令脚本

>数据库操作  
```sql
-- 进入数据库内部
mysql -h 127.0.0.1 -P 3300 -u root -p

-- 执行sql脚本
source /home/20220221.sql
source /sql/sigx.sql
                      
source /var/log/mysql/111.sql;
source /var/log/mysql/test.sql;
source /var/log/mysql/sigx_config.sql;
                      
                  

-- docker容器外 执行sql脚本
docker exec -i ba46824c3dd2 mysql -uroot -pHzw20011004. jinlangtou > /mydata/jinlangtou.sql;

-- 导出指定数据库 并指定导出位置
mysqldump -u root -p    sigx_cps  > /sql/sigx_cps.sql
mysqldump -uroot -proot sigx_cps  > /var/log/mysql/sigx_cps.sql
mysqldump -u root -p sigx  > /var/log/mysql/sigx.sql
mysqldump -u root -p sigx_config  > /var/log/mysql/sigx_config.sql
          

          
          
mysqldump -uroot -proot sigx_job  > /var/log/mysql/sigx_job.sql
mysqldump -uroot -proot sigx_zmn  > /var/log/mysql/sigx_zmn.sql
mysqldump -uroot -proot sigx_cps  > /var/log/mysql/sigx_cps.sql

-- 查看日志

SHOW VARIABLES LIKE "general_log%";  --off 是关闭，如果是on表示已经开启
SET GLOBAL general_log = 'on';  --开启日志监控


-- 执行 .sql脚本文件 
source /root/data/11.sql;

数据库导入字符集
utf8_general_ci --不区分大小写


```





































