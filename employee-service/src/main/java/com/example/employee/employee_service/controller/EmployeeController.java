package com.example.employee.employee_service.controller;

import com.example.employee.employee_service.entity.Employee;
import com.example.employee.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
        public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
            Employee existingEmployee = employeeRepository.findById(id).orElse(null);
            if (existingEmployee != null) {
                employee.setId(id);
                return employeeRepository.save(employee);
            }
            return null;
        }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }


}
