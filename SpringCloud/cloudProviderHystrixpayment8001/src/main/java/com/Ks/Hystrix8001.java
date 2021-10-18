package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname Hystrix8001
 * @Date 2021/10/18 19:12
 * @Created Ks
 */
@SpringBootApplication
@EnableEurekaClient     //查看服务基础信息  该注解用于使用Eureka作为注册中心时注册服务
@EnableCircuitBreaker   //激活降级
public class Hystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001.class,args);
    }

}
