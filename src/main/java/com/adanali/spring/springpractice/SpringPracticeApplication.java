package com.adanali.spring.springpractice;

import com.adanali.spring.springpractice.EcosystemAndCore.ApplicationConfig;
import com.adanali.spring.springpractice.EcosystemAndCore.NotificationService;
import com.adanali.spring.springpractice.MVCBootAndREST.REST.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan("com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot")
@ComponentScan("com.adanali.spring.springpractice.MVCBootAndREST.REST")
@EnableConfigurationProperties(AppProperties.class)
@RestController
public class SpringPracticeApplication /*extends SpringBootServletInitializer*/ {

    @Autowired
    AppProperties appProperties;

    static void main(String[] args) {
/*
        // <-------  Module 1 (Ecosystem And Core)  ------->

        // In Approach 2, Client will have to do the wiring
        *//*NotificationSender sender = new EmailNotificationSender();
        NotificationService service = new NotificationService(sender);*//*

        // Approach 3 : Let Spring do the heavy-lifting
        *//*ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        NotificationService service = context.getBean("notificationService", NotificationService.class);

        service.notifyUser("Welcome!");
        context.close();*//*

        // <-------  Module 2 (Spring MVC, Spring Boot, Spring REST)  ------->
        */
        SpringApplication.run(SpringPracticeApplication.class, args);
    }

    /* For MVC with no Boot
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // point to this class as the main configuration
        return builder.sources(SpringPracticeApplication.class);
    }*/
    @GetMapping
    public String appInfo(){
        return """
                Application Name : %s
                Application Version : %s 
                """.formatted(appProperties.getName(),appProperties.getVersion());
    }
}
