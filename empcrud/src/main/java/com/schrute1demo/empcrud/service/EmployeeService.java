package com.schrute1demo.empcrud.service;

import com.schrute1demo.empcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deletebyId(int theId);

}
