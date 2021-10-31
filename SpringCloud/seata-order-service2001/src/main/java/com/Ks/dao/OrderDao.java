package com.Ks.dao;

import com.Ks.Entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname OrderDao
 * @Date 2021/10/31 15:35
 * @Created Ks
 */
@Mapper
public interface OrderDao {
    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，从 0 改为 1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
