package com.Ks.Config.Filter;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @BelongsProject: baseframe
 * @BelongsPackage: com.lch.management.admin
 * @Author: lch
 * @CreateTime: 2019-10-29 14:00
 * @Description: 安全框架认证失败时 回调处理
 */
@Service
public class AuthFailHandler implements AuthenticationFailureHandler {
//    @Autowired
//    private SysUserMapper sysUserMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse resp,
                                        AuthenticationException e) throws IOException{
        resp.setContentType("application/json;charset=utf-8");
//        R respBean;
        if (e instanceof BadCredentialsException) {
//            respBean = R.err("密码输入错误!");
        } else if (e instanceof UsernameNotFoundException) {
//            respBean = R.err("账户名不存在");
        } else if (e instanceof LockedException) {
//            respBean = R.err("多次密码错误，请稍后再试!");
//            String username = httpServletRequest.getParameter("username");
//            SysUser sysUser = sysUserMapper.selectByName(username);
//            if (sysUser.getLogintime()!=null&&!sysUser.getLogintime().before(new Date())){

//            }
        } else if (e instanceof CredentialsExpiredException) {
//            respBean = R.err("密码过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
//            respBean = R.err("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
//            respBean = R.err("账户被禁用，请联系管理员!");
        } else {
//            respBean = R.err("登录失败!", e.getMessage());
        }
        resp.setStatus(401);
        try (PrintWriter out = resp.getWriter()) {
//            out.write(JSON.toJSONString(respBean));
            out.flush();
        }
    }
}
