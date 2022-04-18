package com.enoca.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_COMPANY")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "COMPANYTYPE")
	private String companyType;

	@Column(name = "COMPANYNAME")
	private String companyName;

	@Column(name = "DESCRIPTION")
	private String description;

	public Company() {
		super();
	}

	public Company(String companyType, String companyName, String description) {
		super();
		this.companyType = companyType;
		this.companyName = companyName;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyType=" + companyType + ", companyName=" + companyName + ", description="
				+ description + "]";
	}

}
