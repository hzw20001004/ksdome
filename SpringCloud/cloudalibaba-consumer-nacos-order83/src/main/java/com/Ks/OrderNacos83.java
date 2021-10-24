package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname OrderNacos83
 * @Date 2021/10/24 21:22
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacos83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacos83.class,args);
    }
}
