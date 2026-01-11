package com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.controllers;

import com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.getAll());
        return "employees";
    }
}
