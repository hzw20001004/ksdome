# SQL的XML脚本

>Sql 基础符号转译
```text
<     转译为：  &lt;
<=    转译为：  &lt;=
>     转译为：  &gt;
>=    转译为：  &gt;=
&     转译为：  amp;
'     转译为：  &apos;
"     转译为：  &quot;
```
> XML
```xml
<if test="queryDto.warehouseNo != null">
    and wsi.warehouse_no = #{queryDto.warehouseNo}
</if>

<!--集合循环-->
<if test="toUser != null and toUser.size != 0">
and iu.user_num in
<foreach item="item" index="index" collection="toUser" open="(" separator="," close=")">
    #{item}
</foreach>
</if>

```



































