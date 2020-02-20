package com.shopping.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

	public User(String username, String password, Long id) {
		super(id);
		this.username = username;
		this.password = password;		
	}

	@Column(unique = true)
	private String username;
	
	@Column
	private String password;
	
	@Column
	private UserState userState;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL, optional=true)
	private ShoppingCart cart;
}
