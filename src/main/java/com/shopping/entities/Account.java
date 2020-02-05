package com.shopping.entities;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
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

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Boolean getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Date getOpen() {
		return open;
	}

	public void setOpen(Date open) {
		this.open = open;
	}

	public Date getClose() {
		return close;
	}

	public void setClose(Date close) {
		this.close = close;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
}
