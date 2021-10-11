package com.Ks.Dao;

import com.Ks.Mapper.ksMapper;
import com.Ks.Pojo.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Date 2021/8/22 21:13
 * @Created by 50857
 */
@Repository
public interface UserDao extends ksMapper<SysUser> {
}
