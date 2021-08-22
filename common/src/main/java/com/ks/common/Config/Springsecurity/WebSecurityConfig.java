package com.ks.common.Config.Springsecurity;

import com.ks.common.Config.Springsecurity.Filter.MyAccessDeniedHandler;
import com.ks.common.Config.Springsecurity.Filter.MyAuthenticationFailureHandler;
import com.ks.common.Config.Springsecurity.Filter.MyAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

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
    /**
     * 异常403 自定义逻辑处理
     */
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    /**
     * 数据源
     */
    @Resource
    private DataSource dataSource;
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
        .loginPage("/login")
        //自定义登录成功地址
        .loginProcessingUrl("/tomain")
        //登录成功自定义转跳地址
        .successHandler(new  MyAuthenticationSuccessHandler("/main"))
        //登录失败自定义转跳地址
        .failureHandler(new MyAuthenticationFailureHandler("/Error"));
        //无权限 异常403 处理
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);
        //记住我功能实现
        http.rememberMe()
                //自定义失效时间
                .tokenValiditySeconds(3*24*60*60)
                //自定义登录逻辑
                .userDetailsService(userDetailsService)
                //指定存储位置
                .tokenRepository(tokenRepository());

        //授权
        http
                //关闭csrf防护策略  因为不使用session
                //.csrf().disable()
                .authorizeRequests()
                //放行登录首页
                .antMatchers("/login").permitAll()
                //放行登录失败页面
                .antMatchers("/error").permitAll();
//                .antMatchers(
//                        HttpMethod.GET,
//                        "/*.html",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js"
//                ).permitAll()
//                .antMatchers("/profile/**").anonymous()
//                .antMatchers("/common/download**").anonymous()
//                .antMatchers("/common/download/resource**").anonymous()
//                .antMatchers("/swagger-ui.html").anonymous()
//                .antMatchers("/swagger-resources/**").anonymous()
//                .antMatchers("/webjars/**").anonymous()
//                .antMatchers("/*/api-docs").anonymous()
//                .antMatchers("/druid/**").anonymous()
                //自定义权限过滤器
                //.anyRequest().access("@myAuthImpl.HasPermission(request,authentication)");
                //.anyRequest().authenticated();
        http.logout()
                //退出登录url
                .logoutUrl("/logout")
                //退出成功到 登录首页
                .logoutSuccessUrl("/login");
    }

    @Bean
    public BCryptPasswordEncoder PW(){
        return new BCryptPasswordEncoder();
    }
    /**
     * 身份认证接口
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(PW());
    }
    @Bean
    public PersistentTokenRepository tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        //配置数据源
        jdbcTokenRepository.setDataSource(dataSource);
        //创建基础表
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
