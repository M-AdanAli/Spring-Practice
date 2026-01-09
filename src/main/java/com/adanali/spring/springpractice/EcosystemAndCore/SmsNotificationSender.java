package com.adanali.spring.springpractice.EcosystemAndCore;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*@Primary
@Component*/
//@Named
public class SmsNotificationSender implements NotificationSender{

    String operatingSystem;

    SmsNotificationSender(String operatingSystem){
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void send(String message) {
        System.out.println("Sms sent via "+operatingSystem+": "+message);
    }
}
