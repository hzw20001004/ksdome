package com.Ks.Exer;

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
public class Employee {

    private String name;
    private Integer age;

}