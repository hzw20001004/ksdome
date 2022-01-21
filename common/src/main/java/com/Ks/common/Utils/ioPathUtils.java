package com.Ks.common.Utils;

/**
 * @Classname ioPathUtils
 * @Date 2022/1/21 14:44
 * @Created Ks
 */
public class ioPathUtils {
  public static void main(String[] args) {
//    user.home：用户主目录
//    user.dir：用户当前的工作目录
//    java.io.tmpdir：默认临时路径
//  自定义绝对路径
    System.out.println("<user.home>: " + System.getProperty("user.home"));
    System.out.println("<user.dir>: " + System.getProperty("user.dir"));
    System.out.println("<java.io.tmpdir>" + System.getProperty("java.io.tmpdir"));
  }

}
