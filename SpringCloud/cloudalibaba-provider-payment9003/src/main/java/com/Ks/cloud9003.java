package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname cloud9003
 * @Date 2021/10/29 18:42
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
public class cloud9003 {
    public static void main(String[] args) {
        SpringApplication.run(cloud9003.class,args);
    }
}
