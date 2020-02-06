package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User extends BaseEntity {

	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private UserState userState;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne(optional=true)
	private ShoppingCart cart;
}
