package com.ks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 */
@Controller
public class LoginController {
//    @RequestMapping("/login")
//    public String login(){
//        //重定向导main.html
//        return "redirect:main.html";
//    }
    @RequestMapping("/tomian")
    public String tomian(){
        //重定向导main.html
        return "redirect:main.html";
    }
    @RequestMapping("/toError")
    public String toError(){
        //重定向导main.html
        return "redirect:error.html";
    }

}
