package com.Ks;

import com.Config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * @Classname Order80
 * @Date 2021/10/8 19:19
 * @Created Ks
 */
@SpringBootApplication
@EnableEurekaClient   //注册服务
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE-8001",configuration = RibbonConfig.class)
public class Order80 {
    public static void main(String[] args) {
        SpringApplication.run(Order80.class,args);
    }
}
