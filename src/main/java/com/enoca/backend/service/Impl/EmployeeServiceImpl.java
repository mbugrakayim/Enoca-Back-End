package com.enoca.backend.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.enoca.backend.exception.NotFoundException;

import com.enoca.backend.model.Employee;

import com.enoca.backend.repository.EmployeeRepository;
import com.enoca.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	


	@Override
	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findByIdEmployee(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
	}

	

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
		employeeRepository.deleteById(id);		
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employe Not Found with id: " + id));
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setTitle(employee.getTitle());
		emp.setCompanyId(employee.getCompanyId());
		return employeeRepository.save(emp);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setAddress(employee.getAddress());
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setPhoneNo(employee.getPhoneNo());
		emp.setTitle(employee.getTitle());
		emp.setCompanyId(employee.getCompanyId());
		return employeeRepository.save(emp);
	}

	
	
}
