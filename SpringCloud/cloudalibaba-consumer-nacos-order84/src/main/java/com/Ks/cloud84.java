package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname cloud84
 * @Date 2021/10/29 19:05
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class cloud84 {
    public static void main(String[] args) {
        SpringApplication.run(cloud84.class,args);
    }
}
