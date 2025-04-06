package com.example.demo.service;

import com.example.demo.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Department createDepartment(Department department);
    Department updateDepartment(int id, Department department);
    String deleteDepartment(int id);
    Page<Department> getAllDepartments(Pageable pageable);
}
