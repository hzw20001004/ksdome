package com.Ks.service.impl;

import com.Ks.Entities.Order;
import com.Ks.dao.OrderDao;
import com.Ks.service.AccountService;
import com.Ks.service.OrderService;
import com.Ks.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname OrderServiceImpl
 * @Date 2021/10/31 15:34
 * @Created Ks
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("-----> 开始新建订单");
        orderDao.create(order);

        log.info("-----> 订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-----> 订单微服务开始调用库存，做扣减 end");

        log.info("-----> 订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-----> 订单微服务开始调用账户，做扣减 end");

        // 修改订单状态，从 0 到 1 代表已经完成
        log.info("-----> 修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-----> 修改订单状态结束");

        log.info("-----> 下订单结束了");

    }
}
