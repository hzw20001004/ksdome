package com.Ks.StreamAPI;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname StreamAPITest3
 * @Date 2021/9/24 20:31
 * 一. Stream 流的操作
 *    1. 创建流
 *    2. 中间操作
 *    3. 终止操作      （实战）
 *       查找与匹配
 *       归约
 *       收集
 * @Created Ks
 */
public class StreamAPITest3 {
    /**
     * 查找与匹配
     * allMatch   - 检查是否匹配所有元素
     * anyMatch   - 检查是否至少匹配一个元素
     * noneMatch  - 检查是否没有匹配所有元素
     * findFirst  - 返回第一个元素
     * findAny    - 返回当前流中的任意元素
     * count      - 返回流中元素的总数
     * max        - 返回流中最大值
     * min        - 返回流中最小值
     *
     * 归约
     * reduce(T identity,BinaryOperator) / reduce(BinaryOperator) - 可以将流中元素反复结合起来, 得到一个值
     *
     * 收集
     * collect - 将流转换为其他形式, 接收一个Collector接口的实现, 用于给Stream中元素这汇总的方法
     *
     *
     */
    //数据
    List<Employee> employees= Arrays.asList(
            new Employee(1,"han",5500d,20, Employee.Stataus.FREE),
            new Employee(3,"tuo",6500d,21, Employee.Stataus.BUSY),
            new Employee(4,"jian",7500d,22, Employee.Stataus.FREE),
            new Employee(7,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",8500d,23, Employee.Stataus.VOCATION),
            new Employee(1,"yao",3500d,23, Employee.Stataus.VOCATION)
    );

    /**
     * allMatch   - 检查是否匹配所有元素
     */
    @Test
    public void test1(){
        //判断所有人工资是否都是5000
        boolean b = employees.stream()
                .allMatch(employee -> employee.getSalary().equals(5000d));
        System.out.println(b);
    }

    /**
     * anyMatch   - 检查是否至少匹配一个元素
     */
    @Test
    public void test2(){
        //判断所有人里是否有人工资是8500
        boolean b = employees.stream().anyMatch(employee -> employee.getSalary().equals(8500d));
        System.out.println(b);
    }
    /**
     * noneMatch  - 检查是否没有匹配所有元素
     */
    @Test
    public void test3(){
        //判断所有人的工资是否都大于40000
        boolean b = employees.stream().noneMatch(e -> e.getSalary() > 40000d);
        System.out.println(b);
    }
    /**
     * findFirst  - 返回第一个元素
     * findAny    - 返回当前流中的任意元素
     */
    @Test
    public void test4(){
        Optional<Employee> sorted = employees.stream()
                .sorted((a, b) -> Double.compare(a.getSalary(), b.getSalary()))
                .findFirst();
        System.out.println(sorted.get());
        Optional<Employee> any = employees.parallelStream()
                .sorted((a, b) -> Double.compare(a.getSalary(), b.getSalary()))
                .findAny();
        System.out.println(any.get());

    }
    /**
     *count      - 返回流中元素的总数
     */
    @Test
    public void test5(){
        //判断高于7000工资有几个人
        long count = employees.stream().filter((e) -> e.getSalary()>7000d).count();
        System.out.println(count);
    }

    /**
     *max        - 返回流中最大值
     */
    @Test
    public void test6(){
        //获取最高工资的员工姓名
        String name = employees.stream().max((a, b) -> Double.compare(a.getSalary(), b.getSalary())).get().getName();
        System.out.println(name);

    }
    /**
     *min        - 返回流中最小值
     */
    @Test
    public void test7(){
        //获取最低工资
        Double aDouble = employees.stream().map(Employee::getSalary).min(Double::compare).get();
        System.out.println(aDouble);
    }
    /**
     * reduce(T identity,BinaryOperator) / reduce(BinaryOperator) - 可以将流中元素反复结合起来, 得到一个值
     */
    @Test
    public void test8(){
        //运算一下数的和
        List<Integer> integers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        //获取所有员工的工资
        Optional<Double> reduce1 = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce1.get());
    }
    /**
     * collect - 将流转换为其他形式, 接收一个Collector接口的实现, 用于给Stream中元素这汇总的方法
     */
    @Test
    public void test9(){
        //把员工姓名进行处理
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        Set<String> collect1 = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(collect1);
        HashSet<String> collect2 = employees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect2);

        //总和
        DoubleSummaryStatistics collect3 = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect3.getSum());
        //平均值
        System.out.println(collect3.getAverage());
        //总数
        System.out.println(collect3.getCount());
        //最大值
        System.out.println(collect3.getMax());
        //最小值
        System.out.println(collect3.getMin());

        //单一分组, 返回 Key Value 格式值
        Map<Employee.Stataus, List<Employee>> collect4 = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getStataus()));
        System.out.println(collect4);

        System.out.println("----------------------------------------------------");
        //多级分组, 返回 Key Value 格式值
        Map<Employee.Stataus, Map<String, List<Employee>>> collect5 = employees.stream().collect(Collectors.groupingBy(employee -> employee.getStataus(), Collectors.groupingBy(e -> {
            if (e.getAge() >= 60) {
                return "老年";
            } else if (e.getAge() >= 30) {
                return "壮年";
            } else {
                return "少年";
            }
        })));
        System.out.println(collect5);

        //分片 分区
        Map<Boolean, List<Employee>> collect6 = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 7000));
        System.out.println(collect6.get(true));

        //串联员工姓名
        String collect7 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",", "---", "---"));
        System.out.println(collect7);
    }











































}
