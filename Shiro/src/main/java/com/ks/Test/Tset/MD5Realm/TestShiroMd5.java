package com.ks.Test.Tset.MD5Realm;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestShiroMd5 {
    public static void main(String[] args) {
          //创建MD5算法
//        Md5Hash md5Hash=new Md5Hash();
//        md5Hash.setBytes("123".getBytes());
//        String s = md5Hash.toHex();
//        System.out.println(s);
        //使用MD5
        Md5Hash md5Hash = new Md5Hash("19");
        System.out.println(md5Hash);
        //使用MD5加盐
        Md5Hash md5Hash1 = new Md5Hash("19", "X0*7ps");
        System.out.println(md5Hash1);
        //使用MD5 + salt + Hash散列 一般都是1024
        Md5Hash md5Hash2 = new Md5Hash("19", "X0*7ps", 1024);
        System.out.println(md5Hash2);
    }
}
