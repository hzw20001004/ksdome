package com.ks.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.common.pojo.System.SysUser;
import com.ks.common.pojo.System.User;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends BaseMapper<SysUser> {
    //CRUD操作已经完成了
}
