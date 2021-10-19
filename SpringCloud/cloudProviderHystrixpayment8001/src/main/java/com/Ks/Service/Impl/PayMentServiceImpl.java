package com.Ks.Service.Impl;

import cn.hutool.core.util.IdUtil;
import com.Ks.Service.PayMentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PayMentServiceImpl
 * @Date 2021/10/18 19:16
 * @Created Ks
 */
@Service
public class PayMentServiceImpl implements PayMentService {
    @Override
    public String paymentIntfo(Integer id) {
        return "线程池：   "+Thread.currentThread().getName()+"  Pay ,Id"+id+"O(∩_∩)O 哈哈 ~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paytime",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentIntfo1(Integer id) {
        Integer time=3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int a=10/0;
        return "线程池：   "+Thread.currentThread().getName()+"  Pay生产者 ,Id"+id+"O(∩_∩)O 哈哈 ~ 耗时3秒";
    }
    public String paytime(Integer id){
        return "线程池：   "+Thread.currentThread().getName()+"  Pay生产者运行错误 ,Id"+id+"(；′⌒`) ";
    }


    //++++++++++++++服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能为复数");
        }
        //获取uuid String
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }
    //兜底类
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试。  id：" + id;
    }







}
