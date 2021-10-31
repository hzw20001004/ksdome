package com.Ks.controller;

import com.Ks.Utils.Dto;
import com.Ks.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Classname AccountController
 * @Date 2021/10/31 15:45
 * @Created Ks
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public Dto decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new Dto(200,"扣减账户余额成功！");
    }
}
