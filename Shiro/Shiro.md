# Shiro Dome
#中文官方文档：
##(http://greycode.github.io/shiro/doc/reference.html)
##Shiro 介绍
##Apache Shiro （发音为“shee-roh”，日语“堡垒（Castle）”的意思）是一个强大灵活的开源安全框架，提供认证、授权、会话管理以及密码加密等功能。
Apache Shiro 首要的目标是易于使用和理解。安全（相关的操作）有时很复杂很麻烦，不过这完全没必要，一个（安全）框架应该尽可能隐藏这其中的复杂性并提供一套简洁直观的 API 来简化开发人员在这方面的工作。
使用 Apache Shiro 可以做到：
验证用户身份。
对用户进行访问控制，比如：
判断某个用户是否被赋予某个特定角色
判断某个用户是否被允许执行某些操作
可以在各种环境下使用 Session API ，即使是不在web或EJB容器中。
对认证、访问控制或在会话生命周期中的事件进行响应处理。
可以聚合使用一个或多个安全数据的数据源而使用者只需了解一层抽象 。
使用单点登录(SSO)。
使用“下次自动登陆（Remember Me）”。
...
等等 - 而所有这些都已经集成于Shiro统一易用的API中。
Shiro 力图在各种应用环境中做到以上——从最简单的命令行程序到庞大的企业应用——而且不依赖于任何的第三方框架、容器或者应用服务器，当然它可以集成到这些环境中，但也能独立使用。

##Shiro主要面向Shiro开发团队所谓的“应用安全的四大基础” ——认证，授权，会话管理与密码加密：
认证： 或“登录”，用以验证用户身份。
授权： 访问控制, 比如决定谁可以访问某些资源。
会话管理： 管理用户相关的session，即使是在非web或EJB应用中。
加密：可以非常方便地使用（各种）加密算法保证数据的安全。

```java
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
        UsernamePasswordToken token= new UsernamePasswordToken("han","20");
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
```
最终源码认证类:
####1：最终执行用户名比较
类 :SimpleAccountRealm.class  在doGetAuthenticationInfo方法里完成用户名的校验
####2：最终密码的校验
类 :AuthenticatingRealm.class 在assertCredentialsMatch方法 密码校验还是由shiro完成校验的,不能自己定义规则
####总结：
AuthenticatingRealm.class  认证realm doGetAuthenticationInfo(AuthenticationToken token)
AuthorizingRealm.class     授权realm doGetAuthorizationInfo(PrincipalCollection principals)

##小知识
```text
MD5 算法
作用：一般用来加密（密码）一般密码用MD5加密都要记得带 "盐" 让密码更安全  或者 签名（检验）
特点：MD5算法是不可逆的 如何内容相同无论多少次MD5生成结果始终一致
不过可以用 穷举算法 反推出来
Md5生成结果：始终是一个16进制32位长度字符串
```

```java
public class TestShiroMd5 {
    public static void main(String[] args) {
        //使用 shiro 中的MD5
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash);
        //使用MD5加盐
        Md5Hash md5Hash1 = new Md5Hash("123", "X0*ps");
        System.out.println(md5Hash1);
        //使用MD5 + salt + Hash散列 一般都是1024
        Md5Hash md5Hash2 = new Md5Hash("123", "X0*ps", 1024);
        System.out.println(md5Hash2);
    }
}
```








































