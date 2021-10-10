package com.Ks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationContextConfig
 * @Date 2021/10/10 22:13
 * @Created Ks
 * 配置类
 */
@Configuration
public class ApplicationContextConfig {
    /**
     *
     * @return
     */
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
