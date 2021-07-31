package com.ks.common.Config.Springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 配置授权服务器
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    private PasswordEncoder pw;
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                //clientid
//                .withClient("ks")
//                //client密码
//                .secret(pw.encode("123456"))
//                //重定向地址
//                .redirectUris("ww.baidu.com")
//                //授权范围
//                .scopes("all")
//                //选择开启授权码模式
//                .authorizedGrantTypes("authorization_code");
//
//    }
}
