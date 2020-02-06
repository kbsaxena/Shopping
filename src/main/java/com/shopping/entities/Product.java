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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product extends BaseEntity {
	
	public Product() {
		this.lineItems = new ArrayList<>();
		this.suppliers = new TreeSet<>();
	}

	@Column
	private String name;
	
	@OneToMany(mappedBy = "product")
	private List<LineItem> lineItems;
	
	@ManyToMany
	@JoinTable(name = "product_supplier", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	private Set<Supplier> suppliers;
}
