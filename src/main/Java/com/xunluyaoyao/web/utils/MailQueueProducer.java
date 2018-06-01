package com.xunluyaoyao.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import javax.jms.*;
import java.util.Map;


@Component
public class MailQueueProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Destination queueMailMapDestination;

    //发送map
    public void sendMap (Map<String, String> request) {
        jmsTemplate.send(queueMailMapDestination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                for (Map.Entry<String, String> entry : request.entrySet()) {
                    mapMessage.setString(entry.getKey(), entry.getValue());
                }
                return mapMessage;
            }
        });
    }
}
