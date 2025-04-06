package com.example.demo.service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;



import com.example.demo.model.Employee;

public interface EmployeeService {
	
	Employee createEmployee(Employee employee);
    Page<Employee> getAllEmployees(Pageable pageable);
    Employee updateEmployee(int id, Employee employee);
    String deleteEmployee(int id);

    
}
