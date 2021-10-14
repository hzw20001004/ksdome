package com.Config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname RibbonConfig
 * @Date 2021/10/14 22:53
 * @Created Ks
 */
@Configuration
public class RibbonConfig {
    @Bean
    public IRule MyRule(){
        return new RandomRule();
    }
}
