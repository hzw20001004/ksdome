package com.ks.StreamAPI;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

/**
 * @Classname
 * ParallelTest
 * @Date 2021/9/27 20:06
 * @Created Ks
 */
public class ParallelTest {
    /**
     * 10个亿的累加
     */
    @Test
    public void test1(){
        long sum=0;
        for (long i = 0; i < 1000000000; i++) {
            sum+=i;
        }
        System.out.println(sum);
    }

    /**
     * java8 的并行流
     */
    @Test
    public void test2(){
        long sum1 = LongStream.rangeClosed(0L, 100000000000L)
                .parallel()
                .sum();
        System.out.println(sum1);
    }
}
