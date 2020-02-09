package com.shopping.services;

import java.util.Optional;

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
		
		Optional<User> userOptional = userRepository.findByUsername(username);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Does not exist");
		} else {
			return passwordEncoder.matches(password, userOptional.get().getPassword());
		}
	}

}