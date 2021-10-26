package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname Nacospaymentprovider9001
 * @Date 2021/10/24 20:40
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient  //激活服务
public class Nacospaymentprovider9001 {
    public static void main(String[] args) {
        SpringApplication.run(Nacospaymentprovider9001.class,args);
    }
}
