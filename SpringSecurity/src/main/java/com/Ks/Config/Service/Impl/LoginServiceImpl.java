package com.Ks.Config.Service.Impl;
import com.Ks.Dao.UserDao;
import com.Ks.pojo.SysUser;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Service
public class LoginServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;
    @Resource
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //判断用户是否存在
        SysUser sysUser = userDao.selectUser(name);
        if (sysUser==null) {
            throw new UsernameNotFoundException("登录用户：" + name + " 不存在");
        }
        //返回用户权限
        return new User(name,passwordEncoder.encode(sysUser.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("/token,/getuser,admin,ROLE_abc,/main,/spring,/select"));
}
    /**
     * 获取菜单数据权限
     *
     * @param user 用户信息
     * @return 菜单权限信息
     */
    public Set<String> getMenuPermission(SysUser user)
    {
        Set<String> perms = new HashSet<String>();
        // 管理员拥有所有权限
            perms.add("*:*:*");
            perms.add("/getuser1");
        return perms;
    }
}
