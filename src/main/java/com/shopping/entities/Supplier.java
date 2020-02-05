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
	
	public Supplier() {
		this.products = new TreeSet<>();
	}

	@Column
	private String name;
	
	@OneToOne
	private Address address;
	
	@ManyToMany(mappedBy = "suppliers")
	private Set<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
