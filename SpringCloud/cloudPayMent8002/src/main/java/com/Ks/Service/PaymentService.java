package com.Ks.Service;

import com.Ks.Entities.Payment;

/**
 * @Classname PaymentService
 * @Date 2021/10/8 20:33
 * @Created Ks
 */
public interface PaymentService {
    /**
     * 新建订单
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据 id 获取订单
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
