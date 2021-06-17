package com.ks.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Userdao extends BaseMapper<User> {
    //CRUD操作已经完成了
}
