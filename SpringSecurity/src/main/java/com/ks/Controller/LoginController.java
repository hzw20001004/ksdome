package com.ks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 */
@Controller
public class LoginController  {
   // @Secured("ROLE_abd")   //严格区分大小写
    @RequestMapping("/main")
    public String tomian(){
        //重定向导main.html
        return "main";
    }
    @RequestMapping("/Error")
    public String toError(){
        //重定向导Error.html
        return "Error";
    }
    @RequestMapping("/spring")
    public String spring(){
        //重定向导SpringSecurityThy.html
        return "SpringSecurityThy";
    }
    @RequestMapping("/login")
    //转跳到登录
    public String login(){
       return "login";
    }
}
