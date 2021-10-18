package com.Ks.Controller;

import com.Ks.Service.FeignPayService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname payController
 * @Date 2021/10/18 20:44
 * @Created Ks
 */
@RestController
@DefaultProperties(defaultFallback = "fa")
public class payController {
    @Autowired
    private FeignPayService feignPayService;

    //全局fa
    public String fa(){
        return "  Pay定义全局消费者运行错误 ";
    }


    @GetMapping(value = "g/{id}")
    public String paymentgetid(@PathVariable("id")Integer id){
        String s = feignPayService.paymentgetid(id);
        System.out.println(s);
        return s;
    }
    @GetMapping(value = "g3/{id}")
//    @HystrixCommand(fallbackMethod = "paytime",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand
    public String paymentgetid31(@PathVariable("id")Integer id){
        int i=10/0;
        String s = feignPayService.paymentgetid3(id);
        System.out.println(s);
        return s;
    }
    public String paytime(Integer id){
        return "  Pay消费者运行错误 ,Id"+id+"(；′⌒`) ";
    }

}
