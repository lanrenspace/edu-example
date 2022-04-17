package com.lanrenspace.edu.service;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
public interface IMessageProducer {


    /**
     * 发送字符串消息
     * @param content
     */
    void sendMessage(String content);
}
