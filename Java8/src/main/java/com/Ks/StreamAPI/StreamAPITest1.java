package com.Ks.StreamAPI;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname StreamAPITest1
 * @Date 2021/9/22 21:31
 * 一. Stream 流的操作
 *    1. 创建流        （实战）
 *    2. 中间操作
 *    3. 终止操作
 * @Created Ks
 */
public class StreamAPITest1 {
    /**
     * 创建流
     */
    @Test
    public void test1(){
        //通过Collection 系列提供的 stream()(是个单线程流的方法) 或 parallelStream()(是个多线程流的方法)
        List<String> strings=new ArrayList<>();
        Stream<String> stream = strings.stream();

        //通过Arrsys 类中的 stream() 方法, 创建数字流
        Integer[] integers = new Integer[10];
        Stream<Object> stream1 = Arrays.stream(integers);

        //通过Stream 类中的 of() 方法
        Stream<String> han = Stream.of("han", "tuo");

        //创建无限流

        //迭代
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 5);
        iterate.limit(10)  //中间操作
               .forEach(System.out::println);  //终止操作
        //生成
        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(10)
                .forEach(System.out::println);

    }



}
