package com.app.micro.controller;

import com.app.micro.entity.Employee;
import com.app.micro.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.saveEmployee(employee);
        model.addAttribute("message", "Employee details saved successfully");
        return "addEmployee";
    }

    @GetMapping("/addPage")
    public String addEmployeePage() {
        return "addEmployee";
    }
}