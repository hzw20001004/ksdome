package com.ks.common.Config.Springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security的配置类
 */
@Configuration
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder PW(){
        return new BCryptPasswordEncoder();
    }
}
