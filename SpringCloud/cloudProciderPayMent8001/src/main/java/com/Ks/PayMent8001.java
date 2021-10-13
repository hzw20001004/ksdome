package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Classname PayMent8001
 * @Date 2021/10/8 19:19
 * @Created Ks
 */
@SpringBootApplication
@EnableEurekaClient   //注册服务
@EnableDiscoveryClient    //查看服务基础信息  该注解用于使用consul或者zookeeper作为注册中心时注册服务
public class PayMent8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8001.class,args);
    }
}
