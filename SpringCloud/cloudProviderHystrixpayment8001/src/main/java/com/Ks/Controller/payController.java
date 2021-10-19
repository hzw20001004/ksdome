package com.Ks.Controller;

import com.Ks.Service.PayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname payController
 * @Date 2021/10/18 19:21
 * @Created Ks
 */
@RestController
public class payController {
    @Autowired
    private PayMentService payMentService;
    @Value("{server.port}")
    private String serverport;
    @GetMapping(value = "get/{id}")
    public String paymentgetid(@PathVariable("id")Integer id){
        String s = payMentService.paymentIntfo(id);
        System.out.println(s);
        return s+ "          "+serverport;
    }
    @GetMapping(value = "get3/{id}")
    public String paymentgetid3(@PathVariable("id")Integer id){
        String s = payMentService.paymentIntfo1(id);
        return s+ "          "+serverport;
    }
    //服务垄断
    @GetMapping(value = "breaker/{id}")
    public String payBreaker(@PathVariable("id")Integer id ) {
        String s = payMentService.paymentCircuitBreaker(id);
        System.out.println(s);
        return s;
    }








}
