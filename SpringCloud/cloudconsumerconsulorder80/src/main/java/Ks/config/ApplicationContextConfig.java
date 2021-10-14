package Ks.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
     * 使用 @LoadBalanced 注解赋予 RestTemplate 负载均衡的能力
     * @return
     */
    @Bean
    @LoadBalanced //实现负载均衡注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
