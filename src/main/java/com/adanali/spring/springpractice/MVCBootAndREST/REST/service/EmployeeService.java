package com.adanali.spring.springpractice.MVCBootAndREST.REST.service;

import com.adanali.spring.springpractice.MVCBootAndREST.REST.model.Employee;

import java.util.List;

public interface EmployeeService {
    boolean save(String name, String role );
    List<Employee> getAll();
    List<Employee> findByRole(String role);
    Employee findById(long id);
}
