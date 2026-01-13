package com.adanali.spring.springpractice.MVCBootAndREST.REST.service;

import com.adanali.spring.springpractice.MVCBootAndREST.REST.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final List<Employee> listOfEmployees;
    private volatile long counter;

    public EmployeeServiceImpl() {
        counter = 0;
        this.listOfEmployees = new ArrayList<>();
        save("Abdullah","Manager");
        save("Ahmed","Front-end Developer");
        save("Ali","Back-end Developer");
    }

    @Override
    public synchronized boolean save(String name, String role) {
        Employee employee = new Employee(++counter,name,role);
        listOfEmployees.add(employee);
        return true;
    }

    @Override
    public List<Employee> getAll(){
        return listOfEmployees;
    }

    @Override
    public List<Employee> findByRole(String role) {
        return listOfEmployees.stream().filter(employee -> employee.getRole().equals(role)).toList();
    }

    @Override
    public Employee findById(long id) {
        return listOfEmployees.stream().filter(employee -> employee.getId() == id).findFirst().orElseThrow();
    }
}
