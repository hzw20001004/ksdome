package com.Ks.Controoler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname infoController
 * @Date 2021/10/20 22:59
 * @Created Ks
 */
@RestController
@RefreshScope
public class infoController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configinfo")
    public String getConfiginfo(){
        return configInfo;
    }
}