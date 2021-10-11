package com.Ks.Exer;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname LambdaExer
 * @Date 2021/9/22 19:27
 * Lambda 表达式的练习
 * @Created Ks
 */
public class LambdaExer {
    /**
     * 1. 调用Collections.sort() 方法, 通过定制排序比较二个 Employee (先按年龄相同按姓名比), 使用Lambda 表达式 作为参数传递.
     */
    //数据
    List<Employee> employees= Arrays.asList(
            new Employee("han",20),
            new Employee("tuo",25),
            new Employee("jian",22),
            new Employee("yao",22),
            new Employee("bing",43)
    );
    @Test
    public void test1(){
        Collections.sort(employees,(a,b)->{
         if (a.getAge().equals(b.getAge())){
             return a.getName().compareTo(b.getName());
         }  else {
             return a.getAge().compareTo(b.getAge());
         }
        });
        employees.forEach(a-> System.out.println(a));
    }



    /**
     * 2. 声明一个函数式接口, 接口中声明抽象方法, public String getValue（String str）;
     *    声明类TestLambda, 类中编写方法使用接口做为参数,将一个字符串换成大写, 并作为方法的返回值.
     *    在将一个字符串的第2个和第4个索引位置进行截取字符串.
     *
     */
    @Test
    public void test2(){
        //把字符串变成大写
        String han = strHandler("han", a -> a.toUpperCase());
        System.out.println(han);

        String han1 = strHandler("han", a -> a.substring(0,3));
        System.out.println(han1);

    }
    public String strHandler(String s,MyInterface myInterface){
        return myInterface.getValue(s);
    }


    /**
     * 3. 声明一个带二个泛型的函数式接口, 泛型类型为<T,R> T为参数, R为返回值
     *    接口中声明对应的抽象方法
     *    在TestLambda 类中声明方法,使用接口作为参数, 计算两个 Long 类型参数的和, 再计算两个 Long 类型参数的乘积.
     */
    @Test
    public void test3(){
        //二数之和
        Long aLong = strFun(10L, 5L, (a, b) -> a+b);
        System.out.println(aLong);
        //二数之积
        Long aLong1 = strFun(10L, 5L, (a, b) -> a*b);
        System.out.println(aLong1);
    }
    public Long strFun(Long L,Long L1,MyFunction<Long,Long> myInterface){
        return myInterface.apply(L,L1);
    }













}
