package com.shopping.entities;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "supplier")
@Getter
@Setter
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
}
