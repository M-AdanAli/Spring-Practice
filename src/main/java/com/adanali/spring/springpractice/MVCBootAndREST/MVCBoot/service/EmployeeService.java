package com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot.service;

import com.adanali.spring.springpractice.MVCBootAndREST.MVCBoot.model.Employee;

import java.util.List;

public interface EmployeeService {
    boolean save(String name, String role );
    List<Employee> getAll();
    List<Employee> findByRole(String role);
    Employee findById(long id);
}
