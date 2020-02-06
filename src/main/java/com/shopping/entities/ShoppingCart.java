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

@Entity
@Table(name="shoppingcart")
public class ShoppingCart extends BaseEntity {
	
	@Column
	private Date created;
	
	@OneToOne(mappedBy="cart")
	private User user;
	
	@OneToOne
	private Account account;
	
	@OneToMany(mappedBy="cart")
	@OrderBy("product")
	private SortedSet<LineItem> lineItems;
	
	public ShoppingCart() {
		lineItems = new TreeSet<>();
	}

	public SortedSet<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(SortedSet<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
