package com.Ks.Service.Impl;

import com.Ks.Dao.PaymentDao;import com.Ks.Service.PaymentService;
import com.Ks.Entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname PaymentServiceImpl
 * @Date 2021/10/8 20:34
 * @Created Ks
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    @Transactional
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
