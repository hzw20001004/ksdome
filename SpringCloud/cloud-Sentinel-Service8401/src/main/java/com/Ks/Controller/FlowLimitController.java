package com.Ks.Controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Classname FlowLimitController
 * @Date 2021/10/28 18:54
 * @Created Ks
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info("[FlowLimitController][testB] threadName:{}...testB", Thread.currentThread().getName());
        return "------testB";
    }
    @GetMapping("/testC")
    public String testC() {
        // 暂停几秒线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("[FlowLimitController][testC] testC 测试 RT");
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        log.info("[FlowLimitController][testD] testD 异常比例");
        int age = 10 / 0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("[FlowLimitController][testE] testE 测试异常数");
        int age = 10 / 0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "------deal_testHotKey";
    }
}
