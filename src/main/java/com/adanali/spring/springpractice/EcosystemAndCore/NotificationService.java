package com.adanali.spring.springpractice.EcosystemAndCore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Component;

// 3rd Approach : Let Spring do the heavy-lifting
/*@Component*/
@Named
public class NotificationService {
    // 1st Approach : Coupling with a specific-implementation
    /*private EmailNotificationSender sender = new EmailNotificationSender();*/

    // 2nd Approach : Adding some Abstraction, But the client has to wire things up
    private NotificationSender sender;

    @Inject
    @Named("emailNotificationSender")
    public NotificationService(NotificationSender sender){
        this.sender = sender;
    }

    public void notifyUser(String message){
        sender.send(message);
    }

    @PostConstruct
    private void init(){
        System.out.println("All the dependencies for the NotificationService are injected.");
    }

    @PreDestroy
    private void cleanUp(){
        System.out.println("No resource to clean in the Notification Service.!");
    }
}
