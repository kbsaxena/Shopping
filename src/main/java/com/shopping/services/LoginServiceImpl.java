package com.shopping.services;

import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.exceptions.UserNotFoundException;
import com.shopping.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public boolean login(String username, String password) {
		log.info("Inside Login Service...");
		boolean status = false;
		Optional<User> userOptional = Optional.empty();

		if (username.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			log.info("Checking By Email...");

			User userDetails = userRepository.userCustomerData(username);
			if(ObjectUtils.isNotEmpty(userDetails)) {
				userOptional = Optional.of(userDetails);
			}
		} else {
			log.info("Checking By Username...");
			userOptional = userRepository.findByUsername(username);
		}
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Does not exist");
		} else {
			status = passwordEncoder.matches(password, userOptional.get().getPassword());
			log.info("Login Successfull!!!");
		}

		return status;
	}

}