package com.ks.Controller;

import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Controllershiro {
    @RequestMapping({"/login"})
    public String home(String name, String passwd,  Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,passwd);
        try{
            subject.login(token);//执行认证方法
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }catch(IncorrectCredentialsException e){
            model.addAttribute("msg", "密码错误");
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "登录失败");
            return "login";
        }
        return "home/home";
    }
    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }
    @RequestMapping("/register")
    public String register(String name, String passwd,  Model model) {
        System.out.println(name);
        System.out.println(passwd);
        model.addAttribute("msg","用户名或密码错误");
        return "home/register";
    }
    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}
