# Sql 基础函数

>数据库操作
```sql
-- 拼接字符  一般用字符模糊查询拼接
like  CONCAT('%',#{id},'%')
-- 替换内容  把用户名称包含人员 替换经办人
update sys_user set name=replace(name,'人员','经办人')

```





































