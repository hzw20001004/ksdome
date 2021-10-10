package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PayMent_URL="Http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 新增订单
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public Dto<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PayMent_URL+"/consumer/payment/create", payment, Dto.class);
    }
    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public  Dto<Payment> getPayMent(@PathVariable("id") Long id){
        return restTemplate.getForObject(PayMent_URL+"/consumer/payment/get/"+id, Dto.class);
    }
}