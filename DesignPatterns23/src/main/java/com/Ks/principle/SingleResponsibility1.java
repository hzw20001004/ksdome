package com.Ks.principle;

/**
 * @Author AW
 * @Date 2022/11/21 14:22
 */
public  class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle1 vehicle = new Vehicle1();
        vehicle.run("奥迪R7s");

    }
}

//交通工具类
//方式1
//违反单一职责原则
//解决方式 根据工具运行方法不同 分解成不同类即可
class Vehicle1{
    public void run (String vehicle){
        System.out.println(vehicle+ "在公路上运行。。。");

    }


}







