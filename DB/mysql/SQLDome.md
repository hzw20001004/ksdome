# Sql 基础语法 Dome

>数据库操作
```sql
-- 创建数据库
create DATABASE 数据库名称;
-- 指定用那个数据
use 数据库名称 
-- 删除数据库
drop DATABASE ;

```

>表操作
```sql
-- 基础建表语句
CREATE TABLE `表名` (
                      `id`  int auto_increment primary key,
                      `create_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',

                      `update_name` varchar(50) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0)  NULL COMMENT '更新人',
                      create_time datetime DEFAULT CURRENT_TIMESTAMP  NULL COMMENT '创建时间',
                      update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP   NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC 
  comment '小程序';

-- 加个字段
alter table JDYY_APP  add isdel  nvarchar(255)
--改变字段类型
alter table custom_target modify column target longtext;
--改变列名称 key关键字
ALTER TABLE test CHANGE `key` keysss  VARCHAR(50);
--删除表里的某个字段
    ALTER TABLE t_xcxshuffling DROP COLUMN sharing_type
-- 就是避免在同一语句中，先select出同一表中的某些值，再update这个表
--修改 同个表的数据
update 表A set 字段=值 where id in (select id from (select 表A.id from wp_posts a left join ......一大长串查询......) 别名);

--修改 表名称
ALTER TABLE QRTZ_LOCKS rename to qrtz_locks

```



>表数据操作

```sql
-- 查询语句
select * from 表名 where 字段名 = 条件值 
-- 修改语句
UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
-- 插入语句
INSERT INTO table_name (列1, 列2,...全列)
INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)


```
































