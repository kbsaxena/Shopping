package com.shopping.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.dto.UserDTO;
import com.shopping.entities.Customer;
import com.shopping.entities.Phone;
import com.shopping.entities.User;
import com.shopping.entities.UserState;
import com.shopping.exceptions.InvalidDetailsException;
import com.shopping.services.RegisterService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(path = "/register")
	@ResponseBody
	public User register(@RequestBody UserDTO user) {
		if (isValidUser(user)) {
			Phone phone = new Phone();
			phone.setCountryCode(user.getCountryCode());
			phone.setMobileNumber(user.getMobileNumber());
			Customer customer = new Customer();
			customer.setFullName(user.getFullname());
			customer.setEmail(user.getEmail());
			customer.setDob(user.getDob());
			customer.setPrimaryPhoneNumber(phone);
			User userObj = new User();
			userObj.setCustomer(customer);
			userObj.setUsername(user.getUsername());
			userObj.setPassword(user.getPassword());
			userObj.setUserState(UserState.NEW);
			registerService.save(userObj);
			registerService.sendValidationLink(userObj);
			return userObj;
		} else {
			throw new InvalidDetailsException("provide valid details..!!!");
		}
	}
	
	@PostMapping(path = "/validate-user")
	@ResponseBody
	public boolean validateUser(@RequestBody Long id) {
		boolean isValidated = false;
		if (id != null) {
			isValidated = registerService.updateUserStatus(id);
		}
		return isValidated;
	}
	
	@PostMapping(path = "/resend-validation-link")
	@ResponseBody
	public boolean resendValidationLink(@RequestBody String email) {
		boolean isSent = false;
		if (StringUtils.isNotBlank(email)) {
			isSent = registerService.resendValidationLinkUsingEmail(email);
		}
		return isSent;
	}

	private boolean isValidUser(UserDTO user) {
		boolean isValid = false;
		if (user != null && StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword()) 
				&& StringUtils.isNotBlank(user.getFullname()) && StringUtils.isNotBlank(user.getEmail()) 
				&& StringUtils.isNotBlank(user.getCountryCode()) && StringUtils.isNotBlank(user.getMobileNumber())) {
			isValid = true;
		}
		return isValid;
	}
}
