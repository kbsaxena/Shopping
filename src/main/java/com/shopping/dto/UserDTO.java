package com.shopping.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private String fullname;
	private String email;
	private String username;
	private String password;
	private String countryCode;
	private String mobileNumber;
	private Date dob;
}
