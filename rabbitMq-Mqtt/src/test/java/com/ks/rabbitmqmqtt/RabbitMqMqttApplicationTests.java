package com.ks.rabbitmqmqtt;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


    @SpringBootTest(classes = RabbitMqMqttApplication.class)
    @RunWith(SpringJUnit4ClassRunner.class)
    @WebAppConfiguration
    public class RabbitMqMqttApplicationTests {


        @Test
        public void testProduce() throws Exception {
        }
    }
