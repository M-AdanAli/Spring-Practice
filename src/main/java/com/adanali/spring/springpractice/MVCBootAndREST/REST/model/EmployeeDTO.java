package com.adanali.spring.springpractice.MVCBootAndREST.REST.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "employee")
public class EmployeeDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
