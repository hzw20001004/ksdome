package Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname cloudconsumerorder
 * @Date 2021/10/14 21:18
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
public class cloudconsumerorder {
    public static void main(String[] args) {
        SpringApplication.run(cloudconsumerorder.class,args);
    }
}
