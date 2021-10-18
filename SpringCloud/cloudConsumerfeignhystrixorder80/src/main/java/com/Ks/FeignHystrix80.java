package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname FeignHystrix80
 * @Date 2021/10/18 20:41
 * @Created Ks
 */
@SpringBootApplication
@EnableFeignClients   //激活Feign
@EnableHystrix        //激活Hystrix
public class FeignHystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrix80.class,args);
    }
}
