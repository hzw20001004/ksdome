package com.ks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        //重定向导main.html
        return "redirect:main.html";
    }
}
