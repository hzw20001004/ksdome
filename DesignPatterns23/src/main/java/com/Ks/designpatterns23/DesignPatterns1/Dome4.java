package com.Ks.designpatterns23.DesignPatterns1;

/**
 * ClassName: Dome4 <br/>
 * date: 2021-08-25 15:22 HZW<br/>
 * 枚举式 （没构造方法，实例唯一，就是单例）
 * 不仅可以解决线程同步，还可以解决反序列化
 */
public enum Dome4 {
    INSTANCE;
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Dome4.INSTANCE.hashCode());
            }).start();
        }
    }
}
