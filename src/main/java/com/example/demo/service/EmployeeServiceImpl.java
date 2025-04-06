package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		
		return employeeRepository.findAll(pageable);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
		
	}

	@Override
	public Employee updateEmployee(int id, Employee updatedEmployee) {
	    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	    if (optionalEmployee.isPresent()) {
	        Employee existingEmployee = optionalEmployee.get();
	        existingEmployee.setEmpName(updatedEmployee.getEmpName());
	        existingEmployee.setEmail(updatedEmployee.getEmail());
	        existingEmployee.setAddress(updatedEmployee.getAddress());
	        existingEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
	        existingEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
	        existingEmployee.setRole(updatedEmployee.getRole());
	        existingEmployee.setSalary(updatedEmployee.getSalary());
	        existingEmployee.setYearlyBonusPercentage(updatedEmployee.getYearlyBonusPercentage());
	        existingEmployee.setDepartment(updatedEmployee.getDepartment());
	        existingEmployee.setReportingManager(updatedEmployee.getReportingManager());
	        return employeeRepository.save(existingEmployee);
	    } else {
	        throw new RuntimeException("Employee not found with id " + id);
	    }
	}


	@Override
	public String deleteEmployee(int id) {
		employeeRepository.deleteById((long) id);
		return "Employee deleted successfully";
	}

	

	


}
