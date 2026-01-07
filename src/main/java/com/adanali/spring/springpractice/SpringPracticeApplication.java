package com.adanali.spring.springpractice;

import com.adanali.spring.springpractice.EcosystemAndCore.NotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringPracticeApplication {

    public static void main(String[] args) {
        // In Approach 2, Client will have to do the wiring
        /*NotificationSender sender =
                new EmailNotificationSender();

        NotificationService service =
                new NotificationService(sender);*/

        // Approach 3 : Let Spring do the heavy-lifting
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        NotificationService service =
                context.getBean("notificationService", NotificationService.class);

        service.notifyUser("Welcome!");
    }

}
