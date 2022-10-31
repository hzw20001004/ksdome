package com.Ks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author AW
 * @Date 2022/10/14 15:37
 */
@RestController
public class test {
    @GetMapping
    public String test(){
        return "成功成功成功";
    }
}
