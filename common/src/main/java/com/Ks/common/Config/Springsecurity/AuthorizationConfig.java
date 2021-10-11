//package com.ks.common.Config.Springsecurity;
//import com.ks.common.Config.Springsecurity.Service.Impl.LoginServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 配置授权服务器
// */
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
//    @Autowired
//    private PasswordEncoder pw;
//    @Autowired
//    private LoginServiceImpl loginService;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private TokenStore jwtTokenStore;
//    @Autowired
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
//    @Autowired
//    private TokenEnhancer tokenEnhancer;
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        List<TokenEnhancer> tokenEnhancers=new ArrayList<>();
//        tokenEnhancers.add(tokenEnhancer);
//        tokenEnhancers.add(jwtAccessTokenConverter);
//        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);
//        endpoints
//                //自定义登录逻辑
//                .userDetailsService(loginService)
//                //授权管理器
//                .authenticationManager(authenticationManager)
//                .tokenStore(jwtTokenStore)
//                .accessTokenConverter(jwtAccessTokenConverter)
//                .tokenEnhancer(tokenEnhancerChain);
//
//
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                //clientid
//                .withClient("admin")
//                //client密码
//                .secret(pw.encode("123456"))
//                //访问令牌失效时间
//                .accessTokenValiditySeconds(36000)
//                //刷新令牌失效时间
//                .refreshTokenValiditySeconds(18000)
//                //重定向地址
//                .redirectUris("ww.baidu.com")
//                //授权范围
//                .scopes("all")
//                //选择开启授权码模式  密码模式  获取刷新令牌
//                .authorizedGrantTypes("authorization_code","password","refresh_token");
//
//    }
//}
