package com.shopping.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.entities.Customer;
import com.shopping.entities.Phone;
import com.shopping.entities.User;
import com.shopping.entities.UserState;
import com.shopping.exceptions.InvalidDetailsException;
import com.shopping.services.RegisterService;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@GetMapping(path = "/register")
	@ResponseBody
	public String register(String name, String user, String pass, String email, String dob, String cc, String number) throws ParseException {
		String response = "Unable to register";
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(user) 
				&& StringUtils.isNotBlank(pass) && StringUtils.isNotBlank(email) 
				&& StringUtils.isNotBlank(dob) && StringUtils.isNotBlank(cc) 
				&& StringUtils.isNotBlank(number)) {
			Phone phone = new Phone();
			phone.setCountryCode(cc);
			phone.setMobileNumber(number);
			Customer customer = new Customer();
			customer.setFullName(name);
			customer.setEmail(email);
			customer.setDob(new SimpleDateFormat("dd-MM-yyyy").parse(dob));
			customer.setPrimaryPhoneNumber(phone);
			User userObj = new User();
			userObj.setCustomer(customer);
			userObj.setUsername(user);
			userObj.setPassword(pass);
			userObj.setUserState(UserState.NEW);
			registerService.save(userObj);
			response = "Success";
		} else {
			throw new InvalidDetailsException("provide valid details..!!!");
		}
		return response;
	}
}
