package com.Ks.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname FeignPayService
 * @Date 2021/10/18 20:46
 * @Created Ks
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = FeignPayFAService.class)
public interface FeignPayService {
    @GetMapping(value = "get/{id}")
    String paymentgetid(@PathVariable("id")Integer id);

    @GetMapping(value = "get3/{id}")
    String paymentgetid3(@PathVariable("id")Integer id);











}
