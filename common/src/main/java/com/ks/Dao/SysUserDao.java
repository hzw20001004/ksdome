package com.ks.Dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ks.pojo.System.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends BaseMapper<SysUser> {
    //CRUD操作已经完成了
}
