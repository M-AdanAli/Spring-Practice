package com.adanali.spring.springpractice.EcosystemAndCore;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class SmsNotificationSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println("Sms send : "+message);
    }
}
