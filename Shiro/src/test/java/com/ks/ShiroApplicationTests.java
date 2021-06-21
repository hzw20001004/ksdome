package com.ks;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ShiroApplicationTests {
    /**
     * 本地单机test Dome
     * shiro基本流程
     */
    @Test
    void contextLoads() {
        //1.创建安全管理器对象
        DefaultSecurityManager defaultSecurityManager =new DefaultSecurityManager();
        //2給安全管理器设置realm
        defaultSecurityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        //3.SecurityUtils 给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //4.关键对象 subject 主体
        Subject subject= SecurityUtils.getSubject();
        //5.创建令牌
        UsernamePasswordToken token= new UsernamePasswordToken("han","19");
        //6令牌放入 subject主体里 用户认证
        try{
            System.out.println("认证状态"+subject.isAuthenticated());
            subject.login(token);
            System.out.println("认证状态"+subject.isAuthenticated());
        }catch (UnknownAccountException e){
            System.out.println("认证失败,用户名不存在");
            e.printStackTrace();
        }catch (IncorrectCredentialsException e){
            System.out.println("认证失败,密码错误");
            e.printStackTrace();
        }
    }
}
