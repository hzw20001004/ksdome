package com.Ks.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname GatewayConfig
 * @Date 2021/10/19 22:10
 * @Created Ks
 */
@Configuration
public class GatewayConfig {
    /**
     * Gateway 路由配置
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
       return builder.routes()
               .route("path1",
                       r->r.path("/guoji")
                       .uri("http://news.baidu.com")).build();

    }
}
