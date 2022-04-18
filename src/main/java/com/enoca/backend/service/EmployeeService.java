package com.enoca.backend.service;


import java.util.List;

import com.enoca.backend.model.Employee;



public interface EmployeeService {

	List<Employee> findAllEmployee();

	Employee findByIdEmployee(Long id);

	Employee updateEmployee(Long id, Employee employee);

	void deleteEmployee(Long id);

	Employee createEmployee(Employee employee);
	

	
}
