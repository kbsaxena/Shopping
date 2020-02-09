package com.shopping.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer extends BaseEntity {
	
	public Customer() {
		address = new ArrayList<>();
		phoneNumbers = new TreeSet<>();
	}
	
	@Column
	private String email;
	
	@Column
	private String fullName;
	
	@Column
	private Date dob;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="customer")
	private Phone primaryPhoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private Set<Phone> phoneNumbers;
	
	@OneToOne(cascade = CascadeType.ALL, optional=true, mappedBy="customer")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
}
