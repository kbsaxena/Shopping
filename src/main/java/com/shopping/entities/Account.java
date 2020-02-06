package com.shopping.entities;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="account")
@Getter
@Setter
public class Account extends BaseEntity {

	public Account() {
		this.orders = new TreeSet<>();
		this.payments = new TreeSet<>();
	}

	@OneToOne
	private Address billingAddress;
	
	@Column
	private Boolean isClosed;
	
	@Column
	private Date open;
	
	@Column
	private Date close;
	
	@OneToMany(mappedBy = "account")
	private Set<Orders> orders;
	
	@OneToMany(mappedBy = "account")
	private Set<Payment> payments;
	
	@OneToOne(mappedBy="account")
	private ShoppingCart shoppingCart;
	
	@OneToOne(mappedBy="account")
	private Customer customer;
}
