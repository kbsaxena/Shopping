package com.shopping.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment extends BaseEntity{
	
	@Column(name = "paid")
	private LocalDate paid;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "details")
	private String details;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
