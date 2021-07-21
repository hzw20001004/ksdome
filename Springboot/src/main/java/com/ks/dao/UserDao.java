package com.ks.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.common.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
    //CRUD操作已经完成了
}
