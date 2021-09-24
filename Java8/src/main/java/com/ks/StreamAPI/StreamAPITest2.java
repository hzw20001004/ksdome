package com.ks.StreamAPI;


import com.ks.StreamAPI.Employee.Stataus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname StreamAPITest2
 * @Date 2021/9/24 20:28
 * 一. Stream 流的操作
 *    1. 创建流
 *    2. 中间操作     （实战）
 *    3. 终止操作
 * @Created Ks
 */
public class StreamAPITest2 {
    /**
     * 筛选与切片
     * filter   - 接受Lambda, 从流中排除某些元素.
     * limit    - 截断流, 使其元素不超过给定数量.
     * skip(n)  - 跳过元素, 返回一个扔掉了前 n 个元素的流. 若流中元素不足 n 个, 则返回一个空流, 与limit（n）互补
     * distinct - 筛选,通过流所产生原素的 hashCode（） 和 equals（）去除 重复元素
     * 映射
     * map      - 接收 Lambda, 将元素转换其他形式或提取信息, 接收一个函数为参数, 该函数会被应用到每个元素上, 并将其映射成一个新的元素.
     * flatMap  - 接收一个函数作为参数,将流中的每个值都换成另一个流, 然后把所有流连接成一个流.
     * 排序
     * soeted() - 自然排序 （Comparable）
     * sorted(Comparator com) - 定制排序
     */

    List<Employee> employees= Arrays.asList(
            new Employee(1,"han",5500d,20, Stataus.FREE),
            new Employee(3,"tuo",6500d,21, Stataus.BUSY),
            new Employee(4,"jian",7500d,22, Stataus.FREE),
            new Employee(7,"yao",8500d,23, Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Stataus.VOCATION),
            new Employee(1,"yao",3500d,23, Stataus.VOCATION)
    );

    /**
     * filter   - 接受Lambda, 从流中排除某些元素.
     */
    @Test
    public void test1(){
        //中间操作 : 不会做任何处理
        Stream<Employee> employeeStream = employees.stream().filter(a -> a.getAge() > 15);
        //终止操作 ： 一次性处理全部,即 "惰性求值"
        employeeStream.forEach(System.out::println); //内部迭代
        //合并操作
        employees.stream().filter(a -> a.getAge() > 15).forEach(employee -> System.out.println(employee));
    }

    /**
     * limit    - 截断流, 使其元素不超过给定数量
     */
    @Test
    public void test2(){
        //id=1 取前二个
    employees.stream().filter(employee -> employee.getId()==1).limit(2).forEach(System.out::println);
    employees.stream().filter(e ->{
        System.out.println("短路");
        return e.getId()==1;
    }).limit(2).forEach(System.out::println);

    }

    /**
     * skip(n)  - 跳过元素, 返回一个扔掉了前 n 个元素的流. 若流中元素不足 n 个, 则返回一个空流, 与limit（n）互补
     */
    @Test
    public void test3(){
        //去掉前5个
    employees.stream().skip(5).forEach(System.out::println);
    }

    /**
     * distinct - 筛选,通过流所产生原素的 hashCode（） 和 equals（）去除 重复元素
     */
    @Test
    public void test4(){
        //去重复
    employees.stream()
             .distinct()
             .forEach(System.out::println);
    }
    /**
     * map      - 接收 Lambda, 将元素转换其他形式或提取信息, 接收一个函数为参数, 该函数会被应用到每个元素上, 并将其映射成一个新的元素.
     */
    @Test
    public void test5(){
        //转换大写
        List<String> list=Arrays.asList("aaa","bbb","vvv");
        list.stream()
            .map(s -> s.toUpperCase())
            .forEach(System.out::println);
        //提取所有名字
        employees.stream()
                 .map(Employee::getName)
                 .forEach(System.out::println);
    }
    /**
     * flatMap  - 接收一个函数作为参数,将流中的每个值都换成另一个流, 然后把所有流连接成一个流.
     */
    @Test
    public void test6(){
        //map 操作单个字符
        List<String> list=Arrays.asList("aaa","bbb","vvv");
        Stream<Stream<Character>> streamStream = list.stream()
                .map(StreamAPITest2::str);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });

        //flatMap 操作单个字符
        list.stream()
            .flatMap(StreamAPITest2::str)
            .forEach(System.out::println);
    }
    public static Stream<Character>  str(String s){
        List<Character> list= new ArrayList<>();
        for (Character character : s.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }
    /**
     * soeted() - 自然排序 （Comparable）
     */
    @Test
    public void test7(){
        employees.stream()
                 .sorted((a,b)->Double.compare(a.getSalary(), b.getSalary()))
                 .forEach(System.out::println);

    }
    /**
     * sorted(Comparator com) - 定制排序
     */
    @Test
    public void test8(){
        employees.stream()
                .sorted()
                .forEach(System.out::println);
    }





















}
