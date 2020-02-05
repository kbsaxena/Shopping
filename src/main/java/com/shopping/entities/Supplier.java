package com.shopping.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {
	
	@Column
	private String name;
	
	@OneToOne
	private Address address;
	
	@ManyToMany(mappedBy = "suppliers")
	private Set<Product> products = new TreeSet<>();
	
}
