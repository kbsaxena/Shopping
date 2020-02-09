package com.shopping.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping(path = "/login")
	@ResponseBody
	public boolean login(String username, String password) {
		boolean isValid = false;
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			isValid = loginService.login(username, password);
		}
		return isValid;
	}
}
