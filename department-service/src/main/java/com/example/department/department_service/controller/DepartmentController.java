package com.example.department.department_service.controller;

import com.example.department.department_service.entity.Department;
import com.example.department.department_service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/{id}")
        public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
            Department existingDepartment = departmentRepository.findById(id).orElse(null);
            if (existingDepartment != null) {
                department.setId(id);
                return departmentRepository.save(department);
            }
            return null;
        }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

}
