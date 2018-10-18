package com.example.training.service;

import java.util.Map;

import com.example.training.model.Employees;

public interface EmployeeService {
	void createEmployee(Employees emp);

	void deleteEmployee(Long empId);

	void updateEmployee(Employees emp);

	Map<String, Object> findEmp(Long empId);

	Map<String, Object> findAllEmp();
}
