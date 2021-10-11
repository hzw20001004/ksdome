package com.Ks.designpatterns23.DesignPatterns1;

/**
 * ClassName: Dome3 <br/>
 * date: 2021-08-25 15:22 HZW<br/>
 * 静态内部类方法
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载 （懒加载：即当对象需要用到的时候再去加载）
 */
public class Dome3 {
    private Dome3(){}


    //创建静态内部类  JVM保证内部类只加载一次
    private static  class setMgr{
        private final static Dome3 INSTANCE =new Dome3();
    }


    //调用静态内部类
    public static  Dome3 getInstance1(){
        return setMgr.INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Dome3.getInstance1().hashCode());
            }).start();
        }
    }
}

