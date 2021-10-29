package com.Ks.Service;

import com.Ks.Service.Impl.payImpl;
import com.Ks.Utils.Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname payService
 * @Date 2021/10/29 19:03
 * @Created Ks
 */
@FeignClient(value = "nacos-payment-provider", fallback = payImpl.class)
public interface payService {
    @GetMapping(value = "/paymentSQL/{id}")
    Dto paymentSQL(@PathVariable("id")Long id);
}
