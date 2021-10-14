package Ks.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ApplicationContextBean
 * @Date 2021/10/14 19:08
 * @Created Ks
 */
@Configuration
public class ApplicationContextBean {
    @Bean
    @LoadBalanced  //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
