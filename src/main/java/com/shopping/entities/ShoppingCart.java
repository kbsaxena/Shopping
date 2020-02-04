package com.shopping.entities;

import java.util.Date;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shoppingcart")
public class ShoppingCart {
	
	@Column
	private Date created;
	
	@OneToOne
	private User user;
	
	@OneToOne
	private Account account;
	
	@OneToMany
	private TreeSet<LineItem> lineItems;

	public TreeSet<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(TreeSet<LineItem> lineItems) {
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
