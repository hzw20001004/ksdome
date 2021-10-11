package com.Ks.MyAnnotation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Classname Employee
 * @Date 2021/9/23 19:20
 * @Created Ks
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MyAnnotation("hello")
@MyAnnotation("ttttt")
public class Employee implements Comparable<Employee> {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private Stataus stataus;

    @Override
    public int compareTo(Employee o) {
        if (this.getAge().equals(o.getAge())){
            return this.getName().compareTo(o.getName());
        }else {
            return this.getAge().compareTo(o.getAge());
        }
    }

    public enum Stataus{
        FREE,
        BUSY,
        VOCATION
    }
}