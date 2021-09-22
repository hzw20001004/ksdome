package com.ks.Lambda;

import org.junit.jupiter.api.Test;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;
/**
 * @Classname MethodRefTest
 * @Date 2021/9/22 19:03
 * 一. 方法引用: 若lambda 表达式, 需要实现的功能, 已经有方法提供了实现, 可以使用方法引用 (方法引用可以理解为 Lambda 表达式的另外一种表现形式)
 * 二. 方法引用的格式
 *     1. 对象的引用 :: 实例方法名
 *     2. 类名 :: 静态方法名
 *     3. 类名 :: 实例方法名
 * 三. 方法引用的注意：  (非常重要)
 *     1. 方法引用的方法参数列表与返回值类型必须与 函数式接口中 抽象方法的参数列表与返回值类型返回一致 ！
 *     2. 返回值类型相同的情况下, 函数式接口中抽象方法参数列表的 的一个参数, 是方法引用的调用者,
 *        第二个参数(无参), 是方法引用方法方法的参数时, 可以使用 类型::实例方法名
 * 四. 构造器引用
 *     格式：类名::new
 * 五. 数组引用
 *     格式：类名[]::new
 *
 * @Created Ks
 */
public class MethodRefTest<test> {
    /**
     *  1. 对象的引用 :: 实例方法名
     *  方法引用的方法参数列表与返回值类型必须与 函数式接口中 抽象方法的参数列表与返回值类型返回一致 ！
     */
    @Test
    public  void test1(){
        //void accept(T t) 与 void println(String X)  抽象方法和返回值类型保持一致!
        PrintStream ps= System.out;
        Consumer<String> consumer=s -> ps.println();
        consumer.accept("han");
        System.out.println("-------------------------------------");
        Consumer<String> consumer1=ps::println;
        consumer1.accept("han1");



        // T get() 与 String getName() 抽象方法和返回值类型保持一致!
        Employee employee = new Employee("han",20);
        Supplier<String> supplier=() -> employee.getName();
        System.out.println(supplier.get());
        System.out.println("-------------------------------------");
        Supplier<String> supplier1=employee::getName;
        System.out.println(supplier1.get());
    }
    /**
     * 2. 类名 :: 静态方法名
     * 方法引用的方法参数列表与返回值类型必须与 函数式接口中 抽象方法的参数列表与返回值类型返回一致 ！
     */
    @Test
    public void test2(){
        // int compare(int x,int y) 与 int compare(T o1,T o2)  静态方法和返回值类型保持一致!
        Comparator<Integer> comparator=(x,y)-> Integer.compare(x,y);
        System.out.println(comparator.compare(5, 7));
        System.out.println("-------------------------------------");
        //
        Comparator<Integer> comparator1=Integer::compare;
        System.out.println(comparator1.compare(3,8));
    }
    /**
     * 2. 类名 :: 实例方法名
     * 返回值类型相同的情况下, 函数式接口中抽象方法参数列表的 的一个参数, 是方法引用的调用者,
     * 第二个参数(无参), 是方法引用方法方法的参数时, 可以使用 类型::实例方法名
     */
    @Test
    public void test3(){
        // boolean test(T t,U u) 与 boolean equals(Object anObject)
        BiPredicate<String,String> biPredicate=(x,y)-> x.equals(y);
        System.out.println(biPredicate.test("han","hello"));
        System.out.println("-------------------------------------");
        BiPredicate<String,String> biPredicate1=String::equals;
        System.out.println(biPredicate.test("han","han"));


        Employee han = new Employee( "han",1);
        Function<Employee,String> function=e->e.getName();
        System.out.println(function);
        System.out.println("-------------------------------------");
        Function<Employee,String> function1=Employee::getName;
    }

    /**
     * 4. 构造器引用
     */
    @Test
    public void test4(){
        //T get();    Employee必须得有无参构造方法
        Supplier<Employee> supplier=()->new Employee();
        System.out.println(supplier.get());
        System.out.println("-------------------------------------");
        Supplier<Employee> supplier1=Employee::new;
        System.out.println(supplier1);

        //R apply(T t, U u); 与 public Employee(String name. Integer age)  参数返回值 类型匹配
        BiFunction<String,Integer,Employee> biFunction=(s,i)->new Employee(s,i);
        Employee han = biFunction.apply("han", 1);
        System.out.println(han);
        BiFunction<String,Integer,Employee> biFunction1=Employee::new;
        System.out.println(biFunction1.apply("hello",1));
    }

    /**
     * 5. 数组引用
     */
    @Test
    public void test5(){
        Function<Integer,String[]> function= i -> new  String[i];
        System.out.println(function.apply(5).length);
        System.out.println("-------------------------------------");
        Function<Integer,String[]> function1=String[]::new;
        System.out.println(function1.apply(10).length);
    }
}
