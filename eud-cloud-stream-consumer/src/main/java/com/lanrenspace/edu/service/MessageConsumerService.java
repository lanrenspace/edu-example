package com.lanrenspace.edu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
// Sink 就相当于定义input 输入通道
@EnableBinding(Sink.class)
public class MessageConsumerService {


    @Value("server.port")
    private int port;

    /**
     * 消费消息
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message)
    {
        System.out.println(port + "接收到的消息:" + message);
    }
}
