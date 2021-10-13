package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname PayMent8001
 * @Date 2021/10/8 19:19
 * @Created Ks
 */
@SpringBootApplication
@EnableEurekaClient   //注册服务
public class PayMent8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8002.class,args);
    }
}
