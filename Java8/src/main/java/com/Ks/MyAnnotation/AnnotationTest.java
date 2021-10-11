package com.Ks.MyAnnotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

/**
 * @Classname AnnotationTest
 * @Date 2021/9/27 21:01
 * 获取重复注解的值
 * @Created Ks
 */
public class AnnotationTest {
    @Test
    public void Test1(){
       //获取类
       Class<Employee> employeeClass=Employee.class;
       //获取类上面的注解
       Annotation[] annotationsByType = employeeClass.getAnnotationsByType(MyAnnotation.class);
       //获取注解里的值 进行遍历
        for (Annotation annotation : annotationsByType) {
            MyAnnotation ma=(MyAnnotation) annotation;
            System.out.println(ma.value());
        }

    }
}
