package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Service.payService;
import com.Ks.Utils.Dto;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Classname payController
 * @Date 2021/10/29 19:01
 * @Created Ks
 */
@RestController
public class payController {
    @Resource
    public payService service;
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    // @SentinelResource(value = "fallback") // 没有配置
    // @SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback 只负责业务异常
    // @SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler 只负责 Sentinel 控制台配置违规
    // @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")  //业务和控制台
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = {IllegalArgumentException.class})  //忽略异常
    public Dto<Payment> fallback(@PathVariable("id") Long id) {
        Dto<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, Dto.class, id);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常....");
        } else if (Objects.isNull(result.getData())) {
            throw new NullPointerException("NullPointerException, 该 ID 没有对应记录，空指针异常");
        }
        return result;
    }

    @GetMapping("/consumer/paymentSQL/{id}")
    public Dto paymentSQL(@PathVariable("id")Long id){
        return service.paymentSQL(id);
    }


    public Dto handlerFallback(@PathVariable("id") Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new Dto(payment,4441,e.getMessage());
    }

    public Dto blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, "null");
        return new Dto(payment,4451,blockException.getMessage());
    }


}
