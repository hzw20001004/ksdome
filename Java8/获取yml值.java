package com.xsl.meetingservice.customize;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // 让 Spring 扫描并管理该类，仅此一个注解即可
public class ConfigReader {
    // 1. 静态变量：用于存储 urlNo，后续直接调用
    public static String URL_NO; // 公共静态变量，直接访问

    // 2. 非静态变量：接收 @Value 注入（Spring 不支持直接注入静态变量）
    @Value("${urlNo}") // 直接绑定 yml 中的 urlNo，无需写全路径（配置无层级）
    private String urlNo;

    // 3. 初始化方法：Spring 注入非静态变量后，自动赋值给静态变量（无需手动调用）
    // 使用 @PostConstruct 注解，容器初始化该 Bean 后自动执行，无需额外操作
    @javax.annotation.PostConstruct
    public void init() {
        ConfigReader.URL_NO = this.urlNo; // 仅这一行赋值代码
    }
}