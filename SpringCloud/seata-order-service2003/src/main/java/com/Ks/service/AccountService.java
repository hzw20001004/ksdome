package com.Ks.service;

import java.math.BigDecimal;

/**
 * @Classname AccountService
 * @Date 2021/10/31 15:46
 * @Created Ks
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
