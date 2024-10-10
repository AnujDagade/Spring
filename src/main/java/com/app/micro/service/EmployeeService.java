package com.app.micro.service;

import com.app.micro.entity.Employee;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class EmployeeService {

    private static final String FILE_PATH = "employees.txt";

    public void saveEmployee(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(employee.getEno() + "," + employee.getEname() + "," + employee.getDesignation() + "," + employee.getDeptName() + "," + employee.getSalary());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}