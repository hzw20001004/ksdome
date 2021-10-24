package com.Ks.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname payController
 * @Date 2021/10/24 20:47
 * @Created Ks
 */
@RestController
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/nacos/{id}")
	public String getPayment(@PathVariable("id") Integer id) {
		return "nacos registry, serverPort:" + serverPort + "\t id:" + id;
	}
}