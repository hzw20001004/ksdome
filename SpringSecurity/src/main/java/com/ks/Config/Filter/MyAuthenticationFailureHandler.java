package com.ks.Config.Filter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录失败逻辑
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final  String URL;
    public MyAuthenticationFailureHandler(String URL){
        this.URL=URL;
    }
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendRedirect(URL);
    }
}
