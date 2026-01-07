package com.adanali.spring.springpractice.EcosystemAndCore;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println("E-mail sent : "+message);
    }
}
