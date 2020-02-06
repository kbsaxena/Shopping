package com.shopping.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Orders extends BaseEntity {
	
	public Orders() {
		this.lineItems = new TreeSet<>();
		this.payments = new TreeSet<>();
	}

	@Column
	private LocalDate ordered;
	
	@Column
	private LocalDate shipped;
	
	@Enumerated
	private OrderStatus status;
	
	@Column
	private Double total;
	
	@OneToOne
	private Address shipTo;
	
	@ManyToOne 
	private Account account;
	
	@OneToMany(mappedBy = "order")
	private Set<LineItem> lineItems;
	
	@OneToMany(mappedBy = "order")
	private Set<Payment> payments;
}
