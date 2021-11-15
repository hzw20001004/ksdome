package com.ks.GJ.Mapper.Select;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Classname selectByIdKs
 * @Date 2021/11/14 20:36
 * @Created Ks
 */
@Slf4j
public class selectByIdKs extends AbstractMethod {
    /**
     * insert into user(id, name, age) values (1, "a", 17), (2, "b", 18);
     <script>
     insert into user(id, name, age) values
     <foreach collection="list" item="item" index="index" open="(" separator="),(" close=")">
     #{item.id}, #{item.name}, #{item.age}
     </foreach>
     </script>
     */
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        final String sql = "<script>insert into %s %s values %s</script>";
        final String sql1 = "<script>select  from #{tablename}</script>";
        final String fieldSql = null;
        final String valueSql = null;
        final String sqlResult = String.format(sql, tableInfo.getTableName(), fieldSql, valueSql);
        log.debug("sqlResult----->{}", sqlResult);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
        // 第三个参数必须和RootMapper的自定义方法名一致
        return this.addInsertMappedStatement(mapperClass, modelClass, "selectByIdKs", sqlSource, new NoKeyGenerator(), null, null);
    }

}
