package com.schrute1demo.empcrud.dao;

import com.schrute1demo.empcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deletebyId(int theId);
}
