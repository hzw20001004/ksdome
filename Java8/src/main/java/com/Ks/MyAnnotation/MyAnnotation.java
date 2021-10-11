package com.Ks.MyAnnotation;

import java.lang.annotation.*;

/**
 * @Classname MyAnnotation
 * @Date 2021/9/27 20:55
 * 单个注解
 * @Created Ks
 */
//支持重复注解
@Repeatable(MyAnnotations.class)
//程序元素
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String value();
}
