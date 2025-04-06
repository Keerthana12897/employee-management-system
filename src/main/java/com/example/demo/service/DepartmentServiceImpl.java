
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(int id, Department updatedDept) {
		Optional<Department> deptOpt = departmentRepository.findById((long) id);
		if (deptOpt.isPresent()) {
			Department dept = deptOpt.get();
			dept.setName(updatedDept.getName());
			dept.setCreationDate(updatedDept.getCreationDate());
			dept.setId(updatedDept.getId());
			return departmentRepository.save(dept);
		}
		throw new RuntimeException("Department not found with id: " + id);
	}

	@Override
	public String deleteDepartment(int id) {
		List<Employee> employees = employeeRepository.findByDepartmentId(id);
		if (!employees.isEmpty()) {
			return "Cannot delete department. Employees are still assigned.";
		}
		departmentRepository.deleteById((long) id);
		return "Department deleted successfully.";
	}

	@Override
	public Page<Department> getAllDepartments(Pageable pageable) {
		return departmentRepository.findAll(pageable);
	}
}
