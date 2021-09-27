package com.ks.StreamAPI;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @Classname OptionalTest
 * 空指针异常类
 * Optional.of(T t) : 创建一个Optional 实例
 * Optional.empty() : 创建一个空的Optional 实例
 * Optional.ofNullable(T t) : 若 t 不为 null, 创建Optional 实例, 否则创建空实例
 *
 * isPresent() : 判断是否包含值
 * orElse(T t) : 如果调用对象包含值, 返回该值, 否则返回 t
 * orElseGet(Supplier s) : 如果调用对象包含值, 返回该值, 否则返回 s 获取的值
 * map(Dunction f) : 如果有值对其处理, 并返回处理后的 Optional, 否则返回Optional.empty()
 * flatMap(Functuon mapper) : 与 map 类似, 要求返回值必须是Optional
 *
 * @Date 2021/9/27 20:26
 * @Created Ks
 */
public class OptionalTest {
    @Test
    public void test1(){
        // Optional.of(T t) : 创建一个Optional 实例
        Optional<Employee> aa = Optional.of(new Employee(1, "aa", 1d, 1, Employee.Stataus.FREE));
        System.out.println(aa.get());
        //Optional.empty() : 创建一个空的Optional 实例
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        //Optional.ofNullable(T t) : 若 t 不为 null, 创建Optional 实例, 否则创建空实例
        Optional<Employee> aa1 = Optional.ofNullable(new Employee(1, "aa", 1d, 1, Employee.Stataus.FREE));
        //isPresent() : 判断是否包含值
        if (aa1.isPresent()){
            System.out.println(aa1.get());
        }
    }

    @Test
    public void test2(){
        // orElse(T t) : 如果调用对象包含值, 返回该值, 否则返回 t
        Optional<Employee> aa = Optional.ofNullable(new Employee(1, "aa", 1d, 1, Employee.Stataus.FREE));
        Employee employee = aa.orElse(new Employee(3, "aa", 1d, 1, Employee.Stataus.FREE));
        System.out.println(employee);

        // orElseGet(Supplier s) : 如果调用对象包含值, 返回该值, 否则返回 s 获取的值
        Employee employee1 = aa.orElseGet(() -> {
            System.out.println("进一步操作");
            return new Employee(1, "aa", 1d, 1, Employee.Stataus.FREE);
        });
        System.out.println(employee1);
    }
    @Test
    public void test3(){
        // map(Dunction f) : 如果有值对其处理, 并返回处理后的 Optional, 否则返回Optional.empty()
        Optional<Employee> han = Optional.ofNullable(new Employee(1, "han", 1d, 1, Employee.Stataus.FREE));
        Optional<String> s = han.map(Employee::getName);
        if (s.isPresent()){
            System.out.println(s.get());
        }
        // flatMap(Functuon mapper) : 与 map 类似, 要求返回值必须是Optional
        Optional<String> s1 = han.flatMap(e -> Optional.ofNullable(e.getName()));
        if (s.isPresent()){
            System.out.println(s1.get());
        }


    }























}
