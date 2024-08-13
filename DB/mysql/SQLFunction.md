# Sql 基础函数

>数据库操作 
```sql
-- 拼接字符  一般用字符模糊查询拼接
like  CONCAT('%',#{id},'%')
-- 替换内容  把用户名称包含人员 替换经办人
update sys_user set name=replace(name,'人员','经办人')
-- 解析一个字段维护json解析  取下标为0 里tenantry
tenantries_json ->> '$[0].tenantry' as '最终承租方名称',
-- 合并相同id 的其他列  并且逗号分隔
select id,GROUP_CONCAT(adds,':',name) as addsname,GROUP_CONCAT(name) as name
from coupon_activity 
group by id
-- 日期格式函数
DATE_FORMAT(wo.ks_create_time, '%Y年%m月%d日')

-- 逗号分隔进行查询
select owner_no,short_name , ww.warehouse_no,ww.name
from wms_owner wo left join wms_warehouse ww  ON FIND_IN_SET(warehouse_no,owner_warehouse) > 0;          

--序号分发器 123456
ROW_NUMBER() OVER (ORDER BY some_column) AS row_num,  -- 根据需要排序的列进行排序


```





































