package com.adanali.spring.springpractice.EcosystemAndCore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    
    @Value("${notificationService}")
    String serviceToUse;
    @Value("#{systemProperties['os.name']}")
    String operatingSystem;

    @Bean
    NotificationSender emailNotificationSender(){
        return new EmailNotificationSender(operatingSystem);
    }

    @Bean
    NotificationSender smsNotificationService(){
        return new SmsNotificationSender(operatingSystem);
    }

    @Bean
    NotificationService notificationService(){
        return switch (serviceToUse){
            case "email" -> new NotificationService(emailNotificationSender());
            case "sms" -> new NotificationService(smsNotificationService());
            default -> throw new IllegalStateException("Unexpected value: " + serviceToUse);
        };
         
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
