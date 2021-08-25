package com.ks.designpatterns23.DesignPatterns1;

/**
 * ClassName: Dome1 <br/>
 * date: 2021-08-25 15:22 HZW<br/>
 * 饿汉式
 * 类加载到内存后，建实例化一个单例，JVM 保证线程安全
 * 唯一缺点，不管用到与否，类装载时就完成实例化 （话说你不用，装载干嘛）也算不上缺点吧
 * 说白了，就是每次取出值一样
 */
public class Dome1 {
    private  static  final  Dome1 INSANCE= new Dome1();


    //private使其变成私有的
    private Dome1(){};


    //加入方法使其可以被使用到
    public static  Dome1 getInstance(){return INSANCE;};


    //进行调用对比取值是否相等
    public static void main(String[] args) {
        Dome1 mgr01=Dome1.getInstance();
        Dome1 mgr02=Dome1.getInstance();
        System.out.println(mgr01==mgr02);
    }
}
