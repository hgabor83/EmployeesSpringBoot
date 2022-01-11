package com.example.employees.Service;

import com.example.employees.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void deleteById(int id);

    Employee findById(int id);

    void save(Employee newEmployee);
}
