package com.ks.common.Config.Springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * Security的配置类
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 自定义用户认证逻辑
     */
    @Autowired
    private UserDetailsService userDetailsService;
//    /**
//     * 认证失败处理类
//     */
//    @Autowired
//    private AuthenticationEntryPointImpl unauthorizedHandler;
//
//    /**
//     * 退出处理类
//     */
//    @Autowired
//    private LogoutSuccessHandlerImpl logoutSuccessHandler;
//
//    /**
//     * token认证过滤器
//     */
//    @Autowired
//    private JwtAuthenticationTokenFilter authenticationTokenFilter;


    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                //自定义登录首页
                .loginPage("/login.html")
         //自定义登录逻辑
        .loginProcessingUrl("/login")
        //登录成功的主界面 必须为post请求
        .successForwardUrl("/tomian")
        //登录失败转跳界面 必须为post请求
        .failureForwardUrl("/toError");
        //授权
        http
                //关闭csrf防护策略  因为不使用session
                .csrf().disable()
                .authorizeRequests()
                //放行登录首页
                .antMatchers("/login.html").permitAll()
                //放行登录失败页面
                .antMatchers("/error.html").permitAll()
                //需认证
                .anyRequest().authenticated();

    }

    @Bean
    public PasswordEncoder PW(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 身份认证接口
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(PW());
    }
}
