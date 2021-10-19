package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Classname Hystrixdashboard9001
 * @Date 2021/10/19 19:36
 * @Created Ks
 */
@SpringBootApplication
@EnableHystrixDashboard   //激活hystrix 图形化监控
public class Hystrixdashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrixdashboard9001.class,args);
    }
}
