package com.shopping.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {
	
	@Column
	private LocalDate paid;
	
	@Column
	private Double total;
	
	@Column
	private String details;
	
	@ManyToOne
	private Orders order;
	
	@ManyToOne
	private Account account;

	public LocalDate getPaid() {
		return paid;
	}

	public void setPaid(LocalDate paid) {
		this.paid = paid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
