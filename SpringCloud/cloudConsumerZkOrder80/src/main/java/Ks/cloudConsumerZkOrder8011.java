package Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname cloudConsumerZkOrder8011
 * @Date 2021/10/14 19:05
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient   //查看服务基础信息  该注解用于使用consul或者zookeeper作为注册中心时注册服务
public class cloudConsumerZkOrder8011 {
    public static void main(String[] args) {
        SpringApplication.run(cloudConsumerZkOrder8011.class,args);
    }
}
