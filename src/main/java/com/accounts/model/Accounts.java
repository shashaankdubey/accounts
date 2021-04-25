package com.accounts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
public class Accounts {

	@Id
	@Column
	@NotNull(message="Id cannot be null")
	private Long id;
	
	@Column
	@NotNull(message="Name cannot be null")
	@Size(min=3, max=150, message="Name should be between 3 and 150")
	private String name;
	
	@Column
	@NotNull(message="Phone cannot be null")
	@Size(min=9, max=12, message="Phone should be between 9 and 12 digits")
	private String phone;
	
	@Column
	@NotNull(message="Email cannot be null")
	@Size(min=1,max=200,message="Length of mail can be from 1 to 200")
	private String email;
	
	@Column
	@Size(max=200,message="Maximum length of address is 200")
	private String address;
	
	@Column
	@NotNull(message="Country cannot be null")
	@Size(min=1,max=56,message="Length of country can be from 1 to 56")
	private String country;
	
	@Column
	@NotNull(message="Department cannot be null")
	@Size(min=1,max=50,message="Length of department can be from 1 to 50")
	private String department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

}
