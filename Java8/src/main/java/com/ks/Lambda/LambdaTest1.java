package com.ks.Lambda;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * ClassName: LambdaTest1 <br/>
 * date: 2021-09-22 15:41 HZW<br/>
 * 一 . Lambda 表达式：java8 中引入了一个新的操作符 “->” , 该操作符称为箭头操作符 或 Lambda 操作符
 *      该操作符将 Lambda 表达式 分为左右二部分：
 *      左侧：函数式接口中抽象方法的参数列表
 *      右侧：对函数式接口中抽象方法的实现, 即 Lambda 体
 *
 * Lambda 表达式需要函数式接口的支持
 * 二 . 函数式接口 定义：接口中只有一个抽象的接口，称为 “函数式接口”。
 *     使用 @FunctionalInterface 注解, 注解: 说明了该接口必须是函数式接口
 *
 * 三 . Lambda 表达式的基础语法:
 *      语法格式一: 无参数,无返回值
 *           写法: () -> System.out.println("java8 中的 Lambda 表达式实现函数式接口");
 *      语法格式二: 一个参数,无返回值
 *           写法: (s) -> System.out.println(s)
 *      语法格式三: 若方法参数只有一个参数时,返回值   (s)可以省略括号
 *           写法: s -> System.out.println(s)
 *      语法格式四: 有多个参数,并有返回值,并且Lambda 体中有多条语句
 *           写法: (x,y)->{
 *             System.out.println("Lambda 体中有多条语句");
 *           return Integer.compare(x.length(),y.length());
 *         };
 *      语法格式五: 若 Lambda 体中只有一条语句,大括号与 return 都可以省略不写
 *           写法: (x,y)-> Integer.compare(x.length(),y.length())
 *
 *
 *
 * @author Administrator<br />
 */
public class LambdaTest1 {
    /**
     * 语法格式一: 无参数,无返回值
     */
    @Test
    public void test1(){
        //基础实现
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类实现接口");
            }
        };
        runnable.run();
        System.out.println("----------------------------------------------------------");
        //使用 lambda 表达式来实现
        Runnable runnable1=() -> System.out.println("java8 中的 Lambda 表达式实现函数式接口");
        runnable1.run();
    }
    /**
     * 语法格式二: 一个参数,无返回值
     */
    @Test
    public void test2(){
        //基础实现
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hello word");
        System.out.println("----------------------------------------------------------");
        //使用 lambda 表达式来实现
        Consumer<String> consumer1=(s) -> System.out.println(s);
        consumer1.accept("han");
    }
    /**
     * 若方法参数只有一个参数时,返回值   (s)可以省略括号
     */
    @Test
    public void test3(){
        //基础实现
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hello word");
        System.out.println("----------------------------------------------------------");
        //使用 lambda 表达式来实现
        Consumer<String> consumer1=s -> System.out.println(s);
        consumer1.accept("han");
    }
    /**
     * 有多个参数,并有返回值,并且Lambda 体中有多条语句
     */
    @Test
    public void test4(){
        //基础实现
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        System.out.println(comparator.compare("han","hello"));
        System.out.println("----------------------------------------------------------");
        //使用 lambda 表达式来实现
        Comparator<String> comparator1=(x,y)->{
            System.out.println("Lambda 体中有多条语句");
          return Integer.compare(x.length(),y.length());
        };
        System.out.println(comparator1.compare("hello","han"));
    }
    /**
     * 有多个参数,并有返回值,并且Lambda 体中有多条语句
     */
    @Test
    public void test5(){
        //基础实现
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        System.out.println(comparator.compare("han","hello"));
        System.out.println("----------------------------------------------------------");
        //使用 lambda 表达式来实现
        Comparator<String> comparator1=(x,y)-> Integer.compare(x.length(),y.length());
        System.out.println(comparator1.compare("hello","han"));
    }




































}
