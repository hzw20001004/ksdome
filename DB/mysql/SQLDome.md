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
                      `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                      `update_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '更新人',
                      `update_time` datetime DEFAULT NULL COMMENT '更新日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC
-- 加个字段
alter table JDYY_APP  add isdel  nvarchar(255)
--改变字段类型
alter table ms_comment CHANGE article_id article_id bigint;　

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



































