package com.shopping.entities;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="shoppingcart")
@Getter
@Setter
public class ShoppingCart extends BaseEntity {
	
	public ShoppingCart() {
		lineItems = new TreeSet<>();
	}
	
	@Column
	private Date created;
	
	@OneToOne(mappedBy="cart")
	private User user;
	
	@OneToOne
	private Account account;
	
	@OneToMany(mappedBy="cart")
	@OrderBy("product")
	private SortedSet<LineItem> lineItems;
}
