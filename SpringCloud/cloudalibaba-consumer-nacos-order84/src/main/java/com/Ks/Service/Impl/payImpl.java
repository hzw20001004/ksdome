package com.Ks.Service.Impl;

import com.Ks.Service.payService;
import com.Ks.Utils.Dto;
import org.springframework.stereotype.Service;

/**
 * @Classname payImpl
 * @Date 2021/10/29 19:03
 * @Created Ks
 */
@Service
public class payImpl implements payService {
    @Override
    public Dto paymentSQL(Long id) {
        return new Dto(446,"异常");
    }
}
