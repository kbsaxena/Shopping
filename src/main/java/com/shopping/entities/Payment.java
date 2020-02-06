package com.shopping.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment")
@Getter
@Setter
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
}
