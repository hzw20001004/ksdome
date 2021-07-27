package com.ks.common.Config.Springsecurity.Filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录成功逻辑
 */

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final  String URL;

    public MyAuthenticationSuccessHandler(String URL){
        this.URL=URL;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getDetails());
        httpServletResponse.sendRedirect(URL);
    }
}
