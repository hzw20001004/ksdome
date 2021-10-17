package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Service.PayMentService;
import com.Ks.Utils.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderFeignController
 * @Date 2021/10/17 21:19
 * @Created Ks
 */
@RestController
public class OrderFeignController {
    @Autowired
    private PayMentService payMentService;
    @GetMapping(value = "/get/{id}")
    public Dto<Payment> getId(@PathVariable("id") Long id){
        Dto<Payment> paymentById = payMentService.getPaymentById(id);
        return paymentById;
    }
    @GetMapping(value = "/Feign")
    public String getFeign(){
        String paymentById = payMentService.getFeign();
        return paymentById;
    }
}
