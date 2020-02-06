package com.shopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.repositories.UserRepository;

@Scope(value = "session")
@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(final User user) {
		return userRepository.save(user);
	}
}
