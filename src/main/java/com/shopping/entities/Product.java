package com.shopping.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "product")
	private List<LineItem> lineItems = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "product_supplier", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	private Set<Supplier> suppliers = new TreeSet<>();
	
}