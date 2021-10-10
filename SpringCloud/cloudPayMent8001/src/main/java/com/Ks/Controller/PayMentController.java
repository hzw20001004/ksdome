package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Service.PaymentService;
import com.Ks.Utils.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@RequestMapping("/consumer/payment")
public class PayMentController {
    @Autowired
    private PaymentService restTemplate;
    /**
     * 新增订单
     * @param payment
     * @return
     * postman 请求参数
     * {
     *     "payment": [
     *         {
     *             "id": "1",
     *             "serial": "韩"
     *         }
     *     ]
     *  }
     */
    @PostMapping("/create")
    public Dto create(@RequestBody Payment payment) {
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
        Payment paymentById = restTemplate.getPaymentById(id);
        return new Dto(paymentById,200,"成功1");
    }
}