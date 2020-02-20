package com.shopping.controllers;

import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@PostMapping(path = "/login")
	@ResponseBody
	public boolean login(@RequestBody Map<String, String> userCredentails) {
		boolean isValid = false;
		if(ObjectUtils.isNotEmpty(userCredentails)) {
			var username = userCredentails.get("username");
			var password = userCredentails.get("password");
			if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
				isValid = loginService.login(username, password);
			}
		}
		return isValid;
	}
}
