package com.ks.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface Userdao extends BaseMapper<User> {
    //CRUD操作已经完成了
}
