package com.Ks.principle;

/**
 * @Author AW
 * @Date 2022/11/21 14:22
 * 方案2的分析
 * 遵守了单一h
 * * *
 */
public  class SingleResponsibility2 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("邮轮");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("奥迪R7s");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("飞机");
    }
}


class RoadVehicle{
    public void run (String vehicle){
        System.out.println(vehicle+ "在水上运行。。。");

    }


}
class AirVehicle{
    public void run (String vehicle){
        System.out.println(vehicle+ "在公路上运行。。。");

    }


}
class WaterVehicle{
    public void run (String vehicle){
        System.out.println(vehicle+ "在天空上运行。。。");

    }


}






