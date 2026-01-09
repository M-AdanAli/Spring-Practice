package com.adanali.spring.springpractice.EcosystemAndCore;

import jakarta.inject.Named;
import org.springframework.stereotype.Component;

/*@Component*/
@Named
public class EmailNotificationSender implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println("E-mail sent : "+message);
    }
}
