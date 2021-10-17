package com.Ks.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname Mylb
 * @Date 2021/10/17 19:53
 * @Created Ks
 */
@Component
public class Mylb implements LoadBalancer{
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    private final int getAndIn(){
        int current;   //
        int next;      //当期访问次数
        do {
            current=this.atomicInteger.get();
            next=current>=2147483647?0:current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next  "+next);
        return next;
    }

    /**
     *
     * @param serviceInstances  当前机器共有多少服务
     * @return
     */
    @Override
    public ServiceInstance INSTANCE(List<ServiceInstance> serviceInstances) {
        //rest 接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标，每次服务重启后 rest 接口计数从 1 开始。
        int i = getAndIn() % serviceInstances.size();



        return serviceInstances.get(i);
    }






}
