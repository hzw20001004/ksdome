package com.Ks.Service;

import org.springframework.stereotype.Component;

/**
 * @Classname FeignPayFAService
 * @Date 2021/10/18 22:09
 * @Created Ks
 */
@Component
public class FeignPayFAService implements FeignPayService{
    @Override
    public String paymentgetid(Integer id) {
        return "impl  异常";
    }

    @Override
    public String paymentgetid3(Integer id) {
        return "impl3  异常";
    }
}
