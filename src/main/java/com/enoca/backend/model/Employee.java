package com.enoca.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.Table;




@Entity
@Table(name = "T_EMPLOYEE")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name ="LAST_NAME")
	private String lastName;
	
	@Column(name =  "PHONE_NO")
	private Long phoneNo;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TITLE")
	private String title;
	

	
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
	private Company companyId;
	
	public Employee() {
		super();
	}


	public Employee(String firstName, String lastName, Long phoneNo, String address, String email, String title,
			 Company companyId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.email = email;
		this.title = title;
		this.companyId = companyId;
	}
	



	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	public Company getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}

	
	
	
	
}
