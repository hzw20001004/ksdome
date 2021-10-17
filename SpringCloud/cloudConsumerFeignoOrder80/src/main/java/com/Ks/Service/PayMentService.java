package com.Ks.Service;

import com.Ks.Entities.Payment;
import com.Ks.Utils.Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname PayMentService
 * @Date 2021/10/17 21:12
 * @Created Ks
 * 创建 feign 接口
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //提供服务地址
public interface PayMentService {
    /**
     * 根据 id 获取订单
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payment/get/{id}")
    Dto<Payment> getPaymentById(@PathVariable("id")Long id);
    @GetMapping(value = "/consumer/payment/Feign")
    String getFeign();

}
