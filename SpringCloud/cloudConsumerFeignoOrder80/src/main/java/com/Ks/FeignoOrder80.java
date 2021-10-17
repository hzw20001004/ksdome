package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname FeignoOrder80
 * @Date 2021/10/17 21:08
 * @Created Ks
 */
@SpringBootApplication
@EnableFeignClients   //激活开启Feign
public class FeignoOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignoOrder80.class,args);
    }
}
