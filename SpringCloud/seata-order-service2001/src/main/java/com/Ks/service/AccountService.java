package com.Ks.service;

import com.Ks.Utils.Dto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Date 2021/10/31 15:34
 * @Created Ks
 */
@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    Dto decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}