package com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.config;

import com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.service.EmployeeService;
import com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.service")
public class AppConfig {

}
