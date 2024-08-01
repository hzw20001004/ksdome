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

```



































