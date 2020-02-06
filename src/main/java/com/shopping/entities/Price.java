package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="price")
@Getter
@Setter
public class Price extends BaseEntity {
	
	@Column
	private Double mrp;
	
	@Column
	private Double discountedPrice;
	
	@OneToOne
	private LineItem lineItem;
}
