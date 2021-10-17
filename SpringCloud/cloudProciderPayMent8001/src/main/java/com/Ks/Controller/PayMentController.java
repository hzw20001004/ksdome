package com.Ks.Controller;


import com.Ks.Entities.Payment;
import com.Ks.Service.PaymentService;
import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class PayMentController {
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PaymentService pay;

    @Resource
    private DiscoveryClient discoveryClient;
    /**
     * 新增订单
     * @param payment
     * @return
     * postman 请求参数
     */
    @PostMapping("/create")
    public Dto<Integer> create(@RequestBody Payment payment) {
        int i = pay.create(payment);
        if (i>0){
            return new Dto(i,200,"成功"+serverPort);
        }
        return new Dto(i,200,"失败"+serverPort);
    }

    /**
     * 查询订单
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Dto<Payment> getPayment(@PathVariable("id") Long id) {
        Payment paymentById =pay.getPaymentById(id);
        return new Dto(paymentById,200,"成功1"+serverPort);
    }

    /**
     * 查看8001的服务配置
     * @return
     */
    @GetMapping("/dis")
    public Object dis(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
           // log.info("service"+service);
            System.out.println("service"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE-8001");
        for (ServiceInstance instance : instances) {
            //log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/pay/lb")
    public String getPsylb(){
        return "端口为   "+serverPort;
    }
@GetMapping(value = "Feign")
public String getFeign(){
    try {
        TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return "端口为   "+serverPort;
}













}