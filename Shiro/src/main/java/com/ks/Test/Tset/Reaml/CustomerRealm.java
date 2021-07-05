package com.ks.Test.Tset.Reaml;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义realm实现
 */
public class CustomerRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //在token中获取用户名
        Object principal = token.getPrincipal();
        System.out.println(principal);
        //根据身份信息与 数据库或数据存储地方的 用户名 进行对比
        if ("han".equals(principal)){
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    //三个参数的意思  数据库查到的用户名   返回数据库正确密码  提供当前realm的名字 this.getName() 知道就行
                    new SimpleAuthenticationInfo("han","123",this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}





