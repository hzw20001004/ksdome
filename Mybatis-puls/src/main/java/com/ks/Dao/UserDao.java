package com.ks.Dao;

import com.ks.Mapper.ksMapper;
import com.ks.Pojo.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Date 2021/8/22 21:13
 * @Created by 50857
 */
@Repository
public interface UserDao extends ksMapper<SysUser> {
}
