package com.Ks.Dao;

import com.Ks.Entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname PaymentDao
 * @Date 2021/10/8 20:16
 * @Created Ks
 */
@Mapper
public interface PaymentDao {
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
    Payment getPaymentById(@Param("id") Long id);
}
