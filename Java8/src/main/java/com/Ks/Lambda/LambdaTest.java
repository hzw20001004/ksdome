package com.Ks.Lambda;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * ClassName: LambdaTest <br/>
 * date: 2021-09-19 16:23 HZW<br/>
 * 简单的介绍了 java8 功能的强大
 * @author Administrator<br />
 */
public class LambdaTest {
    @Test
    public void test1(){
        System.out.println("---------------------java7---------------------");
        //原来的匿名内部类
        Comparator<String> com =new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        TreeSet<String> treeSet=new TreeSet<>(com);
        System.out.println("---------------------java8---------------------");
        //现在的 Lambda 表达式
        Comparator<String> com1=(x,y)->Integer.compare(x.length(),y.length());
        TreeSet<String> treeSet1=new TreeSet<>(com1);

    }
    //数据
    List<Employee> employees= Arrays.asList(
            new Employee("han",20),
            new Employee("tuo",25),
            new Employee("jian",22),
            new Employee("yao",23),
            new Employee("bing",43)
    );

    /**
     * 日常开发使用的方式
     * 需求 获取公司年龄小于 35 的员工
     */
    @Test
    public void employee(){
        List<Employee> filterage = filterage(employees);
        for (Employee employee : filterage) {
            System.out.println(employee);
        }

    }
    public List<Employee> filterage(List<Employee> employees){
        List<Employee> employees1 = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge()<35){
                employees1.add(employee);
            }
        }
        return employees1;
    }


    /**
     * 优化方法一 --- 策略设计模式
     * 需求 获取公司年龄小于 35 的员工
     */
    @Test
    public void employee1(){
        List<Employee> employees1 = filterEmployee(employees, new MyPredicateImpl());
        for (Employee employee : employees1) {
            System.out.println(employee);
        }
    }
    public List<Employee> filterEmployee(List<Employee> employees,MyPredicate<Employee> myPredicate){
        List<Employee> employees1=new ArrayList<>();
        for (Employee employee : employees) {
            if (myPredicate.test(employee)){
                employees1.add(employee);
            }
        }
        return employees1;
    }
    /**
     * 优化方式二 --- 匿名内部类
     * 需求 获取公司年龄小于 35 的员工
     */
    @Test
    public void employee2(){
        List<Employee> employees = filterEmployee(this.employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 35;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    /**
     * 优化方式三 --- java8的 Lambda 表达式
     * 需求 获取公司年龄小于 35 的员工
     */
    @Test
    public void employee3(){
        List<Employee> employees = filterEmployee(this.employees, (a) -> a.getAge() < 35);
        //java8 快捷的循环输出
        employees.forEach(System.out::println);
    }
    /**
     * 优化方式四 --- java8 Lambda 表达式 + Stream API
     * 需求 获取公司年龄小于 35 的员工
     */
    @Test
    public void employee4(){
        employees.stream().filter((a)->a.getAge()<35).forEach(System.out::println);
    }
}



//策略模式接口
interface MyPredicate<T>{
    boolean test(T t);
}
//策略模式实现方法
class MyPredicateImpl implements MyPredicate<Employee>{

    @Override
    public boolean test(Employee employee) {
        return employee.getAge()<35;
    }
}
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Employee {

    private String name;
    private Integer age;

}