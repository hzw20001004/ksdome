package com.ks.Test;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @Classname MQClient
 * @Date 2022/1/14 21:52
 * @Created Ks 收消息
 */

public class MQClient {
    private final String uri = "tcp://localhost:1883";
    private final String clientId = "client_001";
    private final String userName = "guest";
    private final String password = "guest";
    private static MqttClient mqttClient;
    private MqttTopic topic;
    public static   MqttClient getClient() {
        return mqttClient;
    }
    public  MQClient() throws MqttException {
        mqttClient = new MqttClient(uri, clientId,new MemoryPersistence());
        connect();
    }
    public void MQClient1() throws MqttException {
        mqttClient = new MqttClient(uri, clientId,new MemoryPersistence());

    }
    public void connect() throws  MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setCleanSession(false);
        options.setConnectionTimeout(1);
        //设置断开后重新连接
        options.setAutomaticReconnect(true);
        options.setKeepAliveInterval(1);
        mqttClient.setCallback(new MQTTCallback());
        topic = mqttClient.getTopic("artemis/event_face/3187675137/admin");
        mqttClient.connect(options);
    }
    public void subscribe(String[] topic,int[] qos) throws MqttException {
        mqttClient.subscribe(topic, qos);
    }
    public static void main(String[] args) throws MqttException {
        MQClient mqClient = new MQClient();
        String[] topic = {"artemis/event_face/3187675137/admin"};
        int[] qos = {0};
        mqClient.subscribe(topic, qos);
    }

}
