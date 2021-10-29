package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Utils.Dto;
import com.Ks.myhandler.CustomerBlockHandler;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname RateLimitController
 * @Date 2021/10/28 18:55
 * @Created Ks
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public Dto byResource() {
        return new Dto(new Payment(2021L, "serial001"),200,"成功");
    }

    public Dto handleException(BlockException exception) {
        return new Dto(444, exception.getClass().getCanonicalName() + "/t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public Dto byUrl() {
        return new Dto( new Payment(2021L, "serial002"),200,"成功");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public Dto customerBlockHandler() {
        return new Dto( new Payment(2021L, "serial003"),200,"成功");
    }











}
