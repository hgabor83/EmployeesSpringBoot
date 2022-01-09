package com.example.employees.Controller;

import com.example.employees.Entity.Employee;
import com.example.employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    private Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeService.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    private Employee one(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PutMapping("/employees/{id}")
    private Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable int id) {
        //TBD
            return new Employee();
    }

    @DeleteMapping("/employees/{id}")
    private void deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
    }

}
