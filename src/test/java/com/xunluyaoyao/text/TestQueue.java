package com.xunluyaoyao.text;

import com.xunluyaoyao.web.utils.MailQueueProducer;
import com.xunluyaoyao.web.utils.MsgQueueProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jms-producer.xml")
public class TestQueue {
    @Autowired
    private MsgQueueProducer msgQueueProducer;
    @Autowired
    private MailQueueProducer mailQueueProducer;

//    @Test
//    public void smsMapSend() {
//        Map<String, String> request = new HashMap<>();
//        request.put("mobile", "18817327234");
//        request.put("code", "loveyouhoney111");
//        msgQueueProducer.sendMap(request);
//    }

    @Test
    public void mailMapSend() {
        Map<String, String> request = new HashMap<>();
        request.put("email", "hujforeverlove@126.com");
        request.put("code", "loveyouhoney111");
        msgQueueProducer.sendMap(request);
    }
}
