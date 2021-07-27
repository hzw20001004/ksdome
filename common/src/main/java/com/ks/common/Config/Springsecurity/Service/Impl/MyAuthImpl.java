package com.ks.common.Config.Springsecurity.Service.Impl;

import com.ks.common.Config.Springsecurity.Service.MyAuth;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Service
public class MyAuthImpl implements MyAuth {

    @Override
    public boolean HasPermission(HttpServletRequest request, Authentication authentication) {
        //获取url
        String requestURI = request.getRequestURI();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            //获取当前用户所有权限
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            //判断是否有这个url权限
            return authorities.contains(new SimpleGrantedAuthority(requestURI));
        }
       return false;
    }
}
