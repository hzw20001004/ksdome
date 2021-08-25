package com.ks.designpatterns23.DesignPatterns1;

/**
 * ClassName: Dome2 <br/>
 * date: 2021-08-25 15:22 HZW<br/>
 * 懒汉式
 * 虽然达到了按需初始化的目的，
 */
public class Dome2 {
    private static volatile Dome2 INSTANCE;

    //加个判空 但却带来线程不安全问题 因为每次 .hashCode()值有可能不一样
    public static  Dome2 getInstance1(){
        if (INSTANCE==null){
            //卡一下线程
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE=new Dome2();
        }
        return INSTANCE;
    }


    //加个锁可以保证线程安全，可是减低效率
    public static synchronized Dome2 getInstance2(){
        if (INSTANCE==null){
            //卡一下线程
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE=new Dome2();
        }
        return INSTANCE;
    }


    //内部加个锁可以保证线程安全，双重检查单例写法
    public static Dome2 getInstance3(){
        if (INSTANCE==null){
            //进来直接锁，之后就没进入了
            synchronized (Dome2.class){
                if (INSTANCE==null){
                    //卡一下线程
                    try{
                        Thread.sleep(1);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE=new Dome2();
                }
            }
        }
        return INSTANCE;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Dome2.getInstance1().hashCode());
            }).start();
        }
    }


}
