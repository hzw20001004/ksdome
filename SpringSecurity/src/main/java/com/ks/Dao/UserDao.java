package com.ks.Dao;

import com.ks.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Date 2021/8/22 17:53
 * @Created by 50857
 */

@Repository
public interface UserDao {
    @Select("select * from sys_user where userName=#{name}")
    SysUser selectUser(@Param(value = "name")String name);

}
