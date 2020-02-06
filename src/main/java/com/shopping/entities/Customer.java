package com.shopping.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer extends BaseEntity {
	
	@Column
	private String email;
	
	@Column
	private String fullName;
	
	@Column
	private Date dob;
	
	@OneToMany
	private List<Address> address;
	
	@OneToMany(mappedBy="customer")
	private Set<Phone> phoneNumbers;
	
	@OneToOne(optional=true, mappedBy="customer")
	private User user;
	
	@OneToOne
	private Account account;
	
	public Customer() {
		address = new ArrayList<>();
		phoneNumbers = new TreeSet<>();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setPhoneNumbers(Set<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
