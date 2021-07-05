package com.ks.Test.Tset.MD5Realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义realm实现 + MD5 + salt + Hash散列  加密
 */
public class CustomerMd5Realm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取身份信息
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        System.out.println(primaryPrincipal);
        //根据身份信息去获取 用户 或者角色信息 ,权限进行授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addRole("user");



        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取身份信息
        Object principal = token.getPrincipal();
        //根据用户名去数据库查询密码
        if ("han".equals(principal)){
            return new SimpleAuthenticationInfo(
                    //参数1: 数据库查到的用户名 参数2: 返回数据库md5+盐 的密码  提供当前realm的名字 参数3: 注册时的随机盐 参数4：当前realm的名字
                    principal,
                    "ca2b15b3f72653fe5ebadae535469d4f",
                    ByteSource.Util.bytes("X0*7ps"),
                    this.getName());
        }
        return null;
    }
}
