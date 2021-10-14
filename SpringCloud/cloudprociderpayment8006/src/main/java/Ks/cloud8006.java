package Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname cloud8006
 * @Date 2021/10/14 21:00
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
public class cloud8006 {
    public static void main(String[] args) {
        SpringApplication.run(cloud8006.class,args);
    }
}
