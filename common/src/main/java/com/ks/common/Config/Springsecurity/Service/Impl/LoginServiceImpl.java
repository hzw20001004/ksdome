package com.ks.common.Config.Springsecurity.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ks.Dao.SysUserDao;
import com.ks.common.Utils.String.StringUtils;
import com.ks.common.enums.UserStatus;
import com.ks.pojo.System.SysUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder pw;
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //判断用户是否存在
        System.out.println("ewrewrew");
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("username", name);
        SysUser sysUser =sysUserDao.selectOne(queryWrapper);
        if (StringUtils.isNull(sysUser)) {
        throw new UsernameNotFoundException("登录用户：" + name + " 不存在");
    } else if (UserStatus.DELETED.getCode().equals(sysUser.getKs())) {
        throw new UsernameNotFoundException("对不起，您的账号：" + name + " 已被删除");
    } else if (UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
        throw new UsernameNotFoundException("对不起，您的账号：" + name + " 已停用");
    }

        return new User(name,pw.encode(sysUser.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_abc,/main.html,/haha,/select"));


        //return createLoginUser(user);

}

//    /**
//     * 根据用户得权限
//     * @param user
//     * @return
//     */
//    public UserDetails createLoginUser(SysUser user)
//    {
//        return new User(user, permissionService.getMenuPermission(user));
//    }
}
