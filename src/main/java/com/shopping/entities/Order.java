package com.shopping.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order extends BaseEntity{
	
	@Column
	private LocalDate ordered;
	
	@Column
	private LocalDate shipped;
	
	@Column
	private OrderStatus status;
	
	@Column
	private Double total;
	
	@OneToOne
	private Address shipTo;
	
	@ManyToOne
	private Account account;
	
	@OneToMany
	private Set<Payment> payments = new TreeSet<>();
	
	@OneToMany
	private Set<LineItem> lineItems = new TreeSet<>();

	public LocalDate getOrdered() {
		return ordered;
	}

	public void setOrdered(LocalDate ordered) {
		this.ordered = ordered;
	}

	public LocalDate getShipped() {
		return shipped;
	}

	public void setShipped(LocalDate shipped) {
		this.shipped = shipped;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Address getShipTo() {
		return shipTo;
	}

	public void setShipTo(Address shipTo) {
		this.shipTo = shipTo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	
}
