package com.adanali.spring.springpractice.MVCBootAndREST.REST.controller;

import com.adanali.spring.springpractice.MVCBootAndREST.REST.model.Employee;
import com.adanali.spring.springpractice.MVCBootAndREST.REST.model.EmployeeCollectionWrapper;
import com.adanali.spring.springpractice.MVCBootAndREST.REST.model.EmployeeDTO;
import com.adanali.spring.springpractice.MVCBootAndREST.REST.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeRESTController {
    private final EmployeeService employeeService;

    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces =
            {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public EmployeeCollectionWrapper getAllAsJSON(@RequestParam(name = "role" , required = false) String role){
        if (role!=null && !role.isEmpty()){
            return new EmployeeCollectionWrapper( employeeService.findByRole(role) );
        }
        return new EmployeeCollectionWrapper( employeeService.getAll() );
    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public Employee getById(@PathVariable long id){
        return employeeService.findById(id);
    }

    @PostMapping(value = "/new", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> add(@RequestBody EmployeeDTO employeeDTO){
        employeeService.save(employeeDTO.getName(), employeeDTO.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee created");
    }
}
