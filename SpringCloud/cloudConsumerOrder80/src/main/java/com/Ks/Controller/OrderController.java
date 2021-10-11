package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@Slf4j
public class OrderController {
    //单机版url
//    public static final String PayMent_URL="Http://localhost:8001";
    //集群版url
    public static final String PayMent_URL="Http://CLOUD-PAYMENT-SERVICE-8001";
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 新增订单
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public Dto<Payment> create(Payment payment) {
        return restTemplate.postForObject(PayMent_URL+"/consumer/payment/create", payment, Dto.class);
    }
    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public  Dto<Payment> getPayMent(@PathVariable("id") Long id){
        Dto forObject = restTemplate.getForObject(PayMent_URL + "/consumer/payment/get/" + id, Dto.class);
        return forObject;
    }
}