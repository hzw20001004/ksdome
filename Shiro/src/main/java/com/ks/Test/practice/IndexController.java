package com.ks.Test.practice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index1(){
        System.out.println("jinlll");
        return "index";
    }
    @RequestMapping("/index1")
    public String index(){
        System.out.println("jinlll111111");
        return "index1";
    }
}