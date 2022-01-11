package com.example.employees.Controller;

import com.example.employees.Entity.Employee;
import com.example.employees.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/main")
    public String getMain(){
        return "main";
    }

    @GetMapping("/employees")
    public String getEmployees(Model theModel){
        theModel.addAttribute("employeeList",employeeService.findAll());
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model theModel){
        Employee employee=new Employee();
        theModel.addAttribute("theEmployee", employee);
        return "add-employee";
    }

    @PostMapping("/saveEmployee")
    private String newEmployee(@ModelAttribute("theEmployee") Employee newEmployee) {
        employeeService.save(newEmployee);
        return "main";
    }

    @GetMapping("/employeeById")
    private String getOneEmployee(@RequestParam(value = "id", required = false) int id, Model theModel) {
        theModel.addAttribute("employeeList",employeeService.findById(id));
        return "list-employees";
    }

    @GetMapping("/showFormForUpdate")
    public String editEmployee(@RequestParam(value = "id", required = false) int id, Model theModel){
        Employee employee=employeeService.findById(id);
        theModel.addAttribute("theEmployee", employee);
        return "update-employee";
    }

    @PostMapping("/updateEmployee")
    private String updateEmployee(@ModelAttribute("theEmployee") Employee newEmployee) {
        employeeService.save(newEmployee);
        return "main";
    }


    @GetMapping("/deleteEmployee")
    private String deleteEmployee(@RequestParam(value = "id", required = false) int id, Model theModel) {
        employeeService.deleteById(id);
        return "main";
    }

}
