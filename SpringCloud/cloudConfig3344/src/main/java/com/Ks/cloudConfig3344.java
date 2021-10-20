package com.Ks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname cloudConfig3344
 * @Date 2021/10/20 21:26
 * @Created Ks
 */
@SpringBootApplication
@EnableConfigServer   //激活配置中心
public class cloudConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(cloudConfig3344.class,args);
    }
}
