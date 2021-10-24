package com.Ks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname PaymentMain9002
 * @Date 2021/10/24 20:47
 * @Created Ks
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain9002.class, args);
	}
}
