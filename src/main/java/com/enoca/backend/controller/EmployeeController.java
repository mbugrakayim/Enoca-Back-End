package com.enoca.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;



import com.enoca.backend.model.Employee;
import com.enoca.backend.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeService.findAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> findByIdEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(employeeService.findByIdEmployee(id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

	@PostMapping("/new")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee) , HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmploye(@PathVariable Long id ,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id , employee) , HttpStatus.CREATED);
	}

}
