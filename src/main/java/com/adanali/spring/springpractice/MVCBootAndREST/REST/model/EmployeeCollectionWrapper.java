package com.adanali.spring.springpractice.MVCBootAndREST.REST.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

@XmlRootElement(name = "employees")
public class EmployeeCollectionWrapper {
    private Collection<Employee> employeeCollection;

    public EmployeeCollectionWrapper(){}

    public EmployeeCollectionWrapper(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlElement(name = "employee")
    public Collection<Employee> getBooks() {
        return this.employeeCollection;
    }

}
