package com.ks.Controller;

import com.ks.common.Utils.Base.BaseController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 */
@Controller
public class LoginController  {
//    @RequestMapping("/login")
//    public String login(){
//        //重定向导main.html
//        return "redirect:main.html";
//    }
   // @Secured("ROLE_abd")   //严格区分大小写
    @RequestMapping("/main")
    public String tomian(){
        //重定向导main.html
        return "main";
    }
    @RequestMapping("/Error")
    public String toError(){
        //重定向导main.html
        return "Error";
    }
    @RequestMapping("/spring")
    public String spring(){
        //重定向导main.html
        return "SpringSecurityThy";
    }
    @RequestMapping("/login")
    public String login(){
       return "login";
    }
}
