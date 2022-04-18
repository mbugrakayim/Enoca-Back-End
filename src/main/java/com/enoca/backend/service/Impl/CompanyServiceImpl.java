package com.enoca.backend.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.backend.exception.NotFoundException;
import com.enoca.backend.model.Company;
import com.enoca.backend.repository.CompanyRepository;
import com.enoca.backend.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> findAllCompany() {
		
		return companyRepository.findAll();
	}

	@Override
	public Company findByIdCompany(Long id) {
		return companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company Not Found with id: " + id));
	}

	@Override
	public Company updateCompany(Long id, Company company) {
		Company comp = companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company Not Found with id: " + id));
		comp.setCompanyName(company.getCompanyName());
		comp.setCompanyType(company.getCompanyType());
		comp.setDescription(company.getDescription());
		return companyRepository.save(comp);
	}

	@Override
	public void deleteCompany(Long id) {
		companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company Not Found with id: " + id));
		companyRepository.deleteById(id);
		
	}

	@Override
	public Company createCompany(Company company) {
		Company comp = new Company();
		comp.setCompanyName(company.getCompanyName());
		comp.setCompanyType(company.getCompanyType());
		comp.setDescription(company.getDescription());
		return companyRepository.save(comp);
	}
	
	
	
}
