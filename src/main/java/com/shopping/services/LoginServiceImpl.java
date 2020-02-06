package com.shopping.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

	private UserRepository userRepository;
	
	public LoginServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean login(String username, String password) {
		log.info("Inside Login Service...");
		
		Optional<User> userOptional = userRepository.findByUsername(username);
		
		if(!userOptional.isPresent()) {
			throw new RuntimeException("User Does not exist");
		} else {
			return userOptional.get().getPassword().equals(password);
		}
	}

}