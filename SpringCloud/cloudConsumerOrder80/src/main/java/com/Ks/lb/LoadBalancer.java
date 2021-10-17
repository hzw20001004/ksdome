package com.Ks.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Classname LoadBalancer
 * @Date 2021/10/17 19:51
 * @Created Ks
 */
public interface LoadBalancer {
    /**
     * 轮询算法得服务地址
     * @param serviceInstances  当前机器共有多少服务
     * @return  返回选中服务地址
     */
    ServiceInstance INSTANCE(List<ServiceInstance>serviceInstances);
}
