package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Service.PaymentService;
import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class PayMentController {
    @Autowired
    private PaymentService restTemplate;
    /**
     * 新增订单
     * @param payment
     * @return
     */
    @GetMapping("/create")
    public Dto create(Payment payment) {
        int i = restTemplate.create(payment);
        if (i>0){
            return new Dto(null,200,"成功");
        }
        return new Dto(null,200,"失败");
    }

    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Dto getPayment(@PathVariable("id") Long id) {
        return new Dto(restTemplate.getPaymentById(id),200,"成功");
    }
}