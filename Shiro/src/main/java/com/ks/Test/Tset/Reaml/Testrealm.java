package com.ks.Test.Tset.Reaml;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;


public class Testrealm {
    public static void main(String[] args) {
        //创建SecurityManager
        DefaultSecurityManager defaultSecurityManager= new DefaultSecurityManager();
        //设置自定义realm
        defaultSecurityManager.setRealm(new CustomerRealm());
        //将创建SecurityManager的 放入安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //将安全工具类获取subject
        Subject subject=SecurityUtils.getSubject();
        //创建token
        UsernamePasswordToken token = new UsernamePasswordToken("han", "19");
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
