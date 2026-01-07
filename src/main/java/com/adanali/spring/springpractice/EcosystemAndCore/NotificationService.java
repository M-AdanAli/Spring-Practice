package com.adanali.spring.springpractice.EcosystemAndCore;

import org.springframework.stereotype.Component;

// 3rd Approach : Let Spring do the heavy-lifting
@Component
public class NotificationService {
    // 1st Approach : Coupling with a specific-implementation
    /*private EmailNotificationSender sender = new EmailNotificationSender();*/

    // 2nd Approach : Adding some Abstraction, But the client has to wire things up
    private NotificationSender sender;

    public NotificationService(NotificationSender sender){
        this.sender = sender;
    }

    public void notifyUser(String message){
        sender.send(message);
    }
}
