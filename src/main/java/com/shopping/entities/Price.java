package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="price")
public class Price extends BaseEntity {
	
	@Column
	private Double mrp;
	
	@Column
	private Double discountedPrice;
	
	@OneToOne
	private LineItem lineItem;

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public Double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public LineItem getLineItem() {
		return lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

}
