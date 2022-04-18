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

import com.enoca.backend.model.Company;
import com.enoca.backend.service.CompanyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public ResponseEntity<List<Company>> findAllCompany() {
		return new ResponseEntity<List<Company>>(companyService.findAllCompany(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Company> findByIdCompany(@PathVariable("id") Long id) {
		return new ResponseEntity<Company>(companyService.findByIdCompany(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
		return new ResponseEntity<Company>(companyService.createCompany(company), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		return new ResponseEntity<Company>(companyService.updateCompany(id, company), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
		companyService.deleteCompany(id);
		return new ResponseEntity<String>("Company deleted successfully!.", HttpStatus.OK);
	}

}
