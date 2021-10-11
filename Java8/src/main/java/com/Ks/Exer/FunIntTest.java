package com.Ks.Exer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Classname FunIntTest
 * @Date 2021/9/23 19:58
 * Java8                 （重要）内置的四大函数式接口
 * 1. Consumer<T> 消费型接口
 *         void accept（T t）;
 *
 * 2. Supplier<T> 供给型接口
 *         T get();
 *
 * 3. Function<T,R> 函数型接口
 *         R apply(T t);
 *
 * 4. Predicate<T> 断言型接口
 *         Boolean test(T t);
 *
 * @Created Ks
 */
public class FunIntTest {
    /**
     * 消费型接口
     */
    @Test
    public void test1(){
    happy(10000,(d)-> System.out.println(d));
    }
    public void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    /**
     * 供给型接口
     */
    @Test
    public void supp(){
        //生成10个数字
        getNumList(10, ()-> (int)(Math.random()*100101000)).forEach(a-> System.out.println(a));
    }
    public List<Integer> getNumList(int i , Supplier<Integer> supplier){
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            integers.add(supplier.get());
        }
        return integers;
    }
    /**
     * 函数型接口
     */
    @Test
    public void fun(){
        //获取字符串的长度
        Integer han = getfun("han", a -> a.length());
        System.out.println(han);
    }
    public Integer getfun(String s, Function<String,Integer> function){

        return function.apply(s);
    }
    /**
     * 断言型接口
     */
    @Test
    public void pre(){
        //判断这个数字是偶数
        Integer i=101;
        boolean getfun = getpre(i, a -> a%2==0);
        System.out.println(getfun);
    }
    public boolean getpre(Integer s, Predicate<Integer> predicate){
        return predicate.test(s);
    }

    @Test
    public void pre1(){

        System.out.println(100/5);
    }









}
