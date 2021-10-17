package com.Ks.Controller;

import com.Ks.Entities.Payment;
import com.Ks.Utils.Dto;
import com.Ks.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@Slf4j
public class OrderController {
    //单机版url
//    public static final String PayMent_URL="Http://localhost:8001";
    //集群版url
    public static final String PayMent_URL="Http://CLOUD-PAYMENT-SERVICE-8001";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancer loadBalancer;
    @Resource
    private org.springframework.cloud.client.discovery.DiscoveryClient discoveryClient;
    /**
     * 新增订单
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")
    public Dto<Payment> create(Payment payment) {
        return restTemplate.postForObject(PayMent_URL+"/consumer/payment/create", payment, Dto.class);
    }
    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public  Dto<Payment> getPayMent(@PathVariable("id") Long id){
        Dto forObject = restTemplate.getForObject(PayMent_URL + "/consumer/payment/get/" + id, Dto.class);
        return forObject;
    }
    /**
     * 新增订单
     * @param payment
     * @return
     */
    @GetMapping("/create1")
    public Dto<Payment> create1(Payment payment) {
        ResponseEntity<Dto> forEntity = restTemplate.postForEntity(PayMent_URL + "/consumer/payment/create", payment, Dto.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new Dto<>(null,444,"失败");
        }
    }
    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/get1/{id}")
    public  Dto<Payment> getPayMent1(@PathVariable("id") Long id){
        ResponseEntity<Dto> forEntity = restTemplate.getForEntity(PayMent_URL + "/consumer/payment/get/" + id, Dto.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new Dto<>(null,444,"失败");
        }
    }
    @GetMapping("pay/lb")
    public String getPaylb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null){
            return "为空";
        }
        ServiceInstance instance = loadBalancer.INSTANCE(instances);
        URI uri = instance.getUri();
        String forObject = restTemplate.getForObject(uri + "/consumer/payment/pay/lb", String.class);
        return forObject;

    }
}