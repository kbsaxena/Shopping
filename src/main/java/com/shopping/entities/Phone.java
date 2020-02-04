package com.shopping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="mobile")
public class Phone extends BaseEntity {
	
	@Column
	private String mobileNumber;
	
	@Column
	private String countryCode;
}
