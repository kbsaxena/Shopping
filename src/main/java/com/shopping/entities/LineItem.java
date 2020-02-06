package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="lineItem")
@Getter
@Setter
public class LineItem extends BaseEntity {

	@Column
	private Integer quantity;
	
	@OneToOne
	private Price price;
	
	@ManyToOne
	private Orders order;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private ShoppingCart cart;
}
