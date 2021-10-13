package com.Ks.Controller;
import com.Ks.Utils.Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Classname PayMentController
 * @Date 2021/10/8 20:36
 * @Created Ks
 */
@RestController
@Slf4j
public class PayMentController {
    @Value("${server.port}")
    private String serverPort;
    /**
     * 测试Zookeeper
     */
    @GetMapping("/payment/zk")
    public Dto<String> create() {
        return new Dto("Zk"+serverPort+"    "+ UUID.randomUUID().toString(),200,"成功");
    }
}