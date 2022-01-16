package com.ks.Test;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @Classname MQTTServer
 * @Date 2022/1/14 21:51
 * @Created Ks   发送消息
 */

public class MQTTServer {
    private final String host="tcp://localhost:1883";
    private final String clientId = "clien_001";
    private final String userName = "guest";
    private final String password = "guest";
    private MqttClient mqttClient;
    private MqttTopic topic;
//    private MqttMessage message;


    //    通过构造函数初始化mqtt的连接
    public MQTTServer() throws MqttException {
//        服务器的地址应该是URI，对于TCP连接使用“tcp：//”方案，对于由SSL / TLS保护的TCP连接使用“ssl：//”方案。
        mqttClient = new MqttClient(host, clientId,new MemoryPersistence());
        connect();
    }
    public void connect() throws MqttSecurityException, MqttException {
//        配置连接的选项，MqttConnectOptions包含控制客户端连接到服务器的方式的选项。
        MqttConnectOptions options = new MqttConnectOptions();
//         设置连接用户名和密码
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
//        设置超时时间
        options.setConnectionTimeout(30);
//        设置心跳时间间隔
        options.setKeepAliveInterval(60);
//        设置服务器是否应该记住重新连接时客户端的状态
        options.setCleanSession(true);
        mqttClient.connect(options);
//        设置消息发送后的回调方法
        mqttClient.setCallback(new MQTTCallback());
//        通过字符串获取MqttTopic类型的主题
        topic = mqttClient.getTopic("topic_001");
    }
    //    将消息发布到服务器上的主题
    public void publish(MqttTopic topic,MqttMessage message) throws  MqttException {
//        将指定的消息发布到此主题，但不等待消息的传递完成。
        MqttDeliveryToken token = topic.publish(message);
//         阻止当前线程，直到与此令牌关联的操作完成为止。
        token.waitForCompletion();
    }
    public static void main(String[] args) throws MqttException {
        // TODO Auto-generated method stub
        MQTTServer server = new MQTTServer();
//        for(int i=0;i<5;i++) {
        MqttMessage message = new MqttMessage();
        message.setQos(2);
        message.setId(100);
        message.setPayload("hello world!".getBytes());
        server.publish(server.topic, message);
//        }
        System.out.println("发送完毕！");
    }
}
