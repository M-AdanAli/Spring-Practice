package com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot.controllers;

import com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot.model.Employee;
import com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot.model.EmployeeForm;
import com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String listEmployees(@RequestParam(name = "role", required = false) String role,
                                Model model) {
        List<Employee> employees;
        if (role != null && !role.isEmpty()) {
            employees = employeeService.findByRole(role);
        } else {
            employees = employeeService.getAll();
        }
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/{id}")
    public String employee(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employees", List.of(employee));
        return "employees";
    }

    @GetMapping("/new")
    public String showEmployeeForm(Model model) {
        model.addAttribute("employeeForm", new EmployeeForm());
        return "employee-form";
    }

    @PostMapping
    public String addEmployee(@Valid @ModelAttribute EmployeeForm form,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeService.save(form.getName(), form.getRole());
        return "redirect:/employees";
    }
}
