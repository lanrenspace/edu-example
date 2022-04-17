package com.lanrenspace.edu.service.impl;

import com.lanrenspace.edu.service.IMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
// 定义为output通道
@EnableBinding(Source.class)
public class MessageProducerImpl implements IMessageProducer {

    @Autowired
    private Source source;

    @Override
    public void sendMessage(String content) {
        // 向MQ中发送消息
        // 并不是直接操作mq，应该是操作spring cloud stream
        source.output().send(MessageBuilder.withPayload(content).build());
    }
}
