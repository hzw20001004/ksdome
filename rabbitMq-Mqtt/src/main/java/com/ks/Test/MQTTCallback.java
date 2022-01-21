package com.ks.Test;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;

/**
 * @Classname MQTTCallback
 * @Date 2022/1/14 21:52
 * @Created Ks 该回调需要实现MqttCallback的接口
 */
@Slf4j
public class MQTTCallback implements MqttCallback, MqttCallbackExtended {
    //    该方法将在与服务器的连接断开时调用
    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("cause"+cause);
        // TODO Auto-generated method stub
        System.out.println("进入connectionLost方法，可以在此重新连接");

        long reconnectTimes = 1;
        while (true) {
            try {
                System.out.println("isConn"+MQClient.getClient().isConnected());
                if (MQClient.getClient().isConnected()) {
                    log.warn("成功");
                    return;
                }
                log.info("mqtt reconnect times = {} try again...", reconnectTimes++);
                MQClient.getClient().reconnect();
            } catch (MqttException e) {
                log.error("", e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                //e1.printStackTrace();
            }
        }
    }
    // 到消息到达服务器是调用此方法
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("进入messageArrived方法---->："+"\n主题："+topic+"\n服务保障："+message.getQos()+
                "\n消息id："+message.getId()+"\n消息体："+new String(message.getPayload()));
    }
    //    该方法在消息发送完成时调用，并且已经收到所有确认时调用此方法
//    接收到已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用。
    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub
        try {
            System.out.println("进入deliveryComplete方法，消息发送是否完成："+token.isComplete()+"/n消息id："+token.getMessageId()+
                    "/n消息服务："+token.getMessage().getQos()+"\n消息内容："+new String(token.getMessage().getPayload()));
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void connectComplete(boolean reconnect, String serverURI) {
        //每次连接成功需指定topic 和 qos
        log.warn(serverURI);
        String[] topic = {"artemis/event_face/3187675137/admin"};
        int[] qos = {0};
        try {
            MQClient.getClient().subscribe(topic,qos);//具体订阅代码
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
