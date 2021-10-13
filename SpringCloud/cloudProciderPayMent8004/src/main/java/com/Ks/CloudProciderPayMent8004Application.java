package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient    //查看服务基础信息  该注解用于使用consul或者zookeeper作为注册中心时注册服务
public class CloudProciderPayMent8004Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProciderPayMent8004Application.class, args);
    }

}
