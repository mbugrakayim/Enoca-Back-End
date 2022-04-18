package com.enoca.backend.service;

import java.util.List;

import com.enoca.backend.model.Company;

public interface CompanyService {

	List<Company> findAllCompany();

	Company findByIdCompany(Long id);

	Company updateCompany(Long id, Company company);

	void deleteCompany(Long id);

	Company createCompany(Company company);

}
