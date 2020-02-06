package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="mobile")
@Getter
@Setter
public class Phone extends BaseEntity {
	
	@Column
	private String mobileNumber;
	
	@Column
	private String countryCode;
	
	@ManyToOne
	private Customer customer;
}
