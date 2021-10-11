package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication


//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@MapperScan("com.ks.dao")//扫描dao mapper
@SpringBootApplication(scanBasePackages = {"com.Ks"})
@MapperScan("com.ks.Dao")//扫描dao mapper
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
