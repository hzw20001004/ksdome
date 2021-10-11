package com.Ks.MyAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname MyAnnotation
 * @Date 2021/9/27 20:55
 * 重复注解
 * @Created Ks
 */
//程序元素
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
 @interface MyAnnotations {
    MyAnnotation[] value();
}
