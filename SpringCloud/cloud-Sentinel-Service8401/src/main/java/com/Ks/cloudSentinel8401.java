package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname cloudSentinel8401
 * @Date 2021/10/28 18:50
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
public class cloudSentinel8401 {
    public static void main(String[] args) {
        SpringApplication.run(cloudSentinel8401.class,args);
    }
}
