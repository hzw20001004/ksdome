package com.Ks;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Classname Hystrix8001
 * @Date 2021/10/18 19:12
 * @Created Ks
 */
@SpringBootApplication
@EnableEurekaClient     //查看服务基础信息  该注解用于使用Eureka作为注册中心时注册服务
@EnableCircuitBreaker   //激活降级
public class Hystrix8001 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8001.class,args);
    }
    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud 升级后的坑
     * ServletRegistrationBean 因为 Springboot 的默认路径不是 "/hystrix.stream"
     * 只要在自己的项目里配置上下面的 servlet 就可以了
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
