package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Classname Eureka7001
 * @Date 2021/10/11 20:25
 * @Created Ks
 * 服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer   //服务注册中心
public class Eureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001.class,args);
    }
}
