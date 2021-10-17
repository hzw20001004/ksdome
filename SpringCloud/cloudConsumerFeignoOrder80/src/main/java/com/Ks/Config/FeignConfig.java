package com.Ks.Config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname FeignConfig
 * @Date 2021/10/17 21:42
 * @Created Ks
 */
@Configuration
public class FeignConfig {
    /**
     * Feign 日志配置
     * @return
     */
    @Bean
    Logger.Level Feignlogger(){
        return Logger.Level.FULL;
    }
}
