package com.ks.Test.Tset.MD5Realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

public class TsetMd5Realm{
    public static void main(String[] args) {
        //创建SecurityManager
        DefaultSecurityManager defaultSecurityManager= new DefaultSecurityManager();
        //设置自定义realm
        CustomerMd5Realm customerMd5Realm = new CustomerMd5Realm();
        defaultSecurityManager.setRealm(customerMd5Realm);
        //设置realm使用hash凭证匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //告诉 hash凭证匹配器是那种加密算法方式
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //告诉 hash凭证匹配器散列次数
        hashedCredentialsMatcher.setHashIterations(1024);
        customerMd5Realm.setCredentialsMatcher(hashedCredentialsMatcher);
        //将创建SecurityManager的 放入安全工具类
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //将安全工具类获取subject
        Subject subject=SecurityUtils.getSubject();
        //创建token
        UsernamePasswordToken token = new UsernamePasswordToken("han", "19");
        try{
            subject.login(token);
            System.out.println("登录成功");
        }catch (UnknownAccountException e){
            System.out.println("认证失败,用户名不存在");
            e.printStackTrace();
        }catch (IncorrectCredentialsException e){
            System.out.println("认证失败,密码错误");
            e.printStackTrace();
        }
        //认证用户进行授权
        if (subject.isAuthenticated()){
            //1.基于角色权限控制
            System.out.println(subject.hasRole("admin"));
            //基于多角色权限控制
            subject.hasAllRoles(Arrays.asList("admin","user"));
            //是否具有其中一个角色
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user"));
            for (Boolean b:booleans){
                System.out.println(b);
            }
            //基于权限字符串的访问控制  资源标识符：操作：资源类型
            System.out.println("权限"+subject.isPermitted("user:*:*"));
        }



















    }
}
