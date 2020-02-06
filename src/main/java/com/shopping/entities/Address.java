package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address extends BaseEntity {
	
	@Column
	private String houseNumber;
	
	@Column
	private String area;
	
	@Column
	private String landmark;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private Integer pincode;
}
