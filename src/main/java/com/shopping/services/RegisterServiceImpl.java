package com.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Scope(value = "session")
@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(final User user) {
		log.info("Inside Register Service...");
		return userRepository.save(user);
	}
}
