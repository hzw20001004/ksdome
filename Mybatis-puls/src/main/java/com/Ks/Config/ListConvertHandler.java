//package com.Ks.Config;
//
//import cn.hutool.core.convert.Convert;
//import cn.hutool.core.util.StrUtil;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedJdbcTypes;
//import org.apache.ibatis.type.MappedTypes;
//import org.apache.ibatis.type.TypeHandler;
//import org.springframework.stereotype.Component;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Classname MeatObjectHandler
// * @Date 2022/1/20 13:39
// * @Created Ks 插入修改动作加入默认值
// * 实体类具体策略注解   @TableField(typeHandler = ListConvertHandler.class)
// */
//@Component
//@MappedJdbcTypes(JdbcType.VARCHAR)  // 数据库类型
//@MappedTypes(List.class)  // 实体类类型
//public class ListConvertHandler implements TypeHandler<List<String>> {
//
//    @Override
//    public void setParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
//        preparedStatement.setString(i, convert(strings));
//    }
//
//    @Override
//    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {
//        if(StrUtil.isNotEmpty(resultSet.getString(s))){
//            return (List<String>) Convert.toList(resultSet.getString(s));
//        }
//        return new ArrayList<>();
//    }
//
//    @Override
//    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
//        if(StrUtil.isNotEmpty(resultSet.getString(i))){
//            return (List<String>) Convert.toList(resultSet.getString(i));
//        }
//        return new ArrayList<>();
//    }
//
//    @Override
//    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
//        if(StrUtil.isNotEmpty(callableStatement.getString(i))){
//            return (List<String>) Convert.toList(callableStatement.getString(i));
//        }
//        return new ArrayList<>();
//    }
//
//    public static String convert(List<String> list) {
//        String s = Convert.toStr(list).replace("[", "").replace("]", "").trim();
//        return StrUtil.isBlank(s) ? null : s;
//    }
//}
