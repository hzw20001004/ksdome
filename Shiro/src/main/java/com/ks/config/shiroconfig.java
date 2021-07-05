package com.ks.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ks.shiro.Realm.CustomerRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro 配置类
 */
@Configuration
public class shiroconfig {
    //1.创建shirofilter  负责拦截全部请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源

        //配置系统公共资源
        Map map=new HashMap();
        map.put("/index","authc");//authc 请求这个资源需要认证和授权
        map.put("/login","anon");//authc 请求这个资源需要认证和授权

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //没权限转跳默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/");


        // 首页
        shiroFilterFactoryBean.setSuccessUrl("/index");





        return shiroFilterFactoryBean;
    }
    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //3.创建自定义realm
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }
    /**
     * thymeleaf模板引擎和shiro框架的整合
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
