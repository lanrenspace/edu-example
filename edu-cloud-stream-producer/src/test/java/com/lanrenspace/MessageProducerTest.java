package com.lanrenspace;

import com.lanrenspace.edu.StreamProducerApplication;
import com.lanrenspace.edu.service.IMessageProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author lanrenspace@163.com
 * @Description:
 **/
@SpringBootTest(classes = {StreamProducerApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageProducerTest {

    @Autowired
    private IMessageProducer messageProducer;

    @Test
    public void testSendMessage() {
        messageProducer.sendMessage("hello stream");
    }
}
