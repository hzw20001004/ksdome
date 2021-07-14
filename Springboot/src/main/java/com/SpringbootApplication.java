package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication


//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@MapperScan("com.ks.dao")//扫描dao mapper
@SpringBootApplication(scanBasePackages = {"com.ks"})
@MapperScan("com.ks.dao")//扫描dao mapper
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
