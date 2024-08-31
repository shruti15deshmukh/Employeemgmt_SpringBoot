package com.schrute1demo.empcrud.rest;


import com.schrute1demo.empcrud.entity.Employee;
import com.schrute1demo.empcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found"+ employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee= employeeService.save(theEmployee);
        return dbEmployee;

    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee=employeeService.findById(employeeId);
        if(tempEmployee==null){
            throw new RuntimeException("Employee not found w id "+employeeId);

        }
        employeeService.deletebyId(employeeId);
        return "deleted emp id "+employeeId;
    }



}
