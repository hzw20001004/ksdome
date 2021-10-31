package com.Ks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Classname SeataOrder2003
 * @Date 2021/10/31 15:06
 * @Created Ks
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan({"com.Ks.dao"})
public class SeataOrder2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2003.class,args);
    }
}
