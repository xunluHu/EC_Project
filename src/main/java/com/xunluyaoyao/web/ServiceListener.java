package com.xunluyaoyao.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

@Component
public class ServiceListener {

    @Autowired
    private MsgUtil msgUtil;
    @Autowired
    private MailUtil mailUtil;


    @JmsListener(destination = "sms")
    public void sendSms(Map<String, String> map) {
        System.out.println(map.size());
        System.out.println(map.get("mobile"));
        System.out.println(map.get("code"));
        try {
            SendSmsResponse response = msgUtil.sendSms(map.get("mobile"), map.get("code"));
            System.out.println("code:" + response.getCode());
            System.out.println("message:" + response.getMessage());
        } catch (ClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @JmsListener(destination = "mail")
    public void sendMail(Map<String, String> map) {
        System.out.println(map.get("email"));
        System.out.println(map.get("code"));
        if (mailUtil.sendMail(map.get("email"), map.get("code"))) {
            System.out.println("邮件发送成功");
        }
    }
}
