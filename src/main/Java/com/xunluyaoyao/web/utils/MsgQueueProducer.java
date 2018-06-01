package com.xunluyaoyao.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.Iterator;
import java.util.Map;


@Component
public class MsgQueueProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination queueMsgMapDestination;

    //发送map
    public void sendMap (Map<String, String> request) {
        jmsTemplate.send(queueMsgMapDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                Iterator<Map.Entry<String, String>> entries = request.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<String, String> entry = entries.next();
                    mapMessage.setString(entry.getKey(), entry.getValue());
                }
                return mapMessage;
            }
        });
    }
}
