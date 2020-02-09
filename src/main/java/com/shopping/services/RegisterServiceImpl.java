package com.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.exceptions.InvalidDetailsException;
import com.shopping.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		log.info("Inside Register Service...");
		if (user != null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		} else {
			throw new InvalidDetailsException("provide valid details");
		}
	}
}
