package com.Ks.controller;

import com.Ks.Entities.Order;
import com.Ks.Utils.Dto;
import com.Ks.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Date 2021/10/31 15:36
 * @Created Ks
 */
@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public Dto create(Order order) {
        orderService.create(order);
        return new Dto(200, "订单创建成功");
    }
}
