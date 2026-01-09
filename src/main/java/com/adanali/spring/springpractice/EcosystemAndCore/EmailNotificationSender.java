package com.adanali.spring.springpractice.EcosystemAndCore;

import jakarta.inject.Named;
import org.springframework.stereotype.Component;

/*@Component*/
/*@Named*/
public class EmailNotificationSender implements NotificationSender{

    String operatingSystem;

    EmailNotificationSender(String operatingSystem){
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void send(String message) {
        System.out.println("E-mail sent via "+operatingSystem+": "+message);
    }
}
