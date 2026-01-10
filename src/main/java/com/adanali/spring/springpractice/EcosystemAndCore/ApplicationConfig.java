package com.adanali.spring.springpractice.EcosystemAndCore;

import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

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

    @Bean(name = "notificationService")
    @ConditionalOnExpression("'${notificationService}' == 'email'")
    NotificationService notificationService1(){
        return new NotificationService(emailNotificationSender());
    }

    @Bean(name = "notificationService")
    @ConditionalOnExpression("'${notificationService}' == 'sms'")
    NotificationService notificationService2(){
        return new NotificationService(smsNotificationService());
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
