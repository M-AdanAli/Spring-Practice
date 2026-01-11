package com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.service;

import com.adanali.spring.springpractice.MVCBootAndREST.MVCNoBoot.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final List<Employee> listOfEmployees;

    public EmployeeServiceImpl() {
        this.listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee(1,"Abdullah","Manager"));
        listOfEmployees.add(new Employee(2,"Ahmed","Front-end Developer"));
        listOfEmployees.add(new Employee(3,"Ali","Backend Developer"));
    }

    @Override
    public List<Employee> getAll(){
        return listOfEmployees;
    }
}
