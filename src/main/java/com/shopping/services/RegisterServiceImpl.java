package com.shopping.services;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopping.entities.User;
import com.shopping.entities.UserState;
import com.shopping.exceptions.InvalidDetailsException;
import com.shopping.exceptions.UserAlreadyRegisteredException;
import com.shopping.exceptions.UserNotFoundException;
import com.shopping.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
	
	private final String SUBJECT = "Welcome to Shopping.com! Confirm Your Email ";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public User save(User user) {
		log.info("Inside Register Service...");
		if (user != null) {
			if (userAlreadyExist(user)) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				return userRepository.save(user);
			} else {
				throw new UserAlreadyRegisteredException("User already registered!");
			}
		} else {
			throw new InvalidDetailsException("provide valid details");
		}
	}

	private boolean userAlreadyExist(final User user) {
		boolean isExist = false;
		Optional<User> userOptional = Optional.empty();
		User userDetails = userRepository.userCustomerData(user.getUsername());
		if(ObjectUtils.isNotEmpty(userDetails)) {
			userOptional = Optional.of(userDetails);
		}
		if (userOptional.isPresent()) {
			isExist = true;
		}
		userOptional = userRepository.findByUsername(user.getUsername());
		if (!userOptional.isPresent()) {
			isExist = true;
		}
		return isExist;
	}
	
	@Override
	public void sendValidationLink(User user) {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setFrom("shopping.kbs.rpk@gmail.com");
	        helper.setTo(user.getCustomer().getEmail());
	        helper.setSubject(SUBJECT);
	        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
	        if (userOptional.isPresent()) {
	        	helper.setText("<a href=\"http://localhost:4200/validate-user/" + userOptional.get().getId() + "\">Click Here!</a> to confirm you are email ID", true);
	            javaMailSender.send(msg);
	        } else {
	        	throw new UserNotFoundException("Unable to fetch user details");
	        }
		} catch (MessagingException e) {
			throw new UserNotFoundException("Unable to fetch user details");
		}
	}

	@Override
	public boolean updateUserStatus(Long id) {
		boolean isUpdated = false;
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			userOptional.get().setUserState(UserState.ACTIVE);
			userRepository.save(userOptional.get());
			isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean resendValidationLinkUsingEmail(String email) {
		boolean isSent = false;
		try {
			User userDetails = userRepository.userCustomerData(email);
	        if (userDetails != null) {
				MimeMessage msg = javaMailSender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		        helper.setFrom("shopping.kbs.rpk@gmail.com");
		        helper.setTo(email);
		        helper.setSubject(SUBJECT);	        
	        	helper.setText("<a href=\"http://localhost:4200/validate-user/" + userDetails.getId() + "\">Click Here!</a> to confirm you are email ID", true);
	            javaMailSender.send(msg);
	        } else {
	        	throw new UserNotFoundException("Unable to fetch user details");
	        }
		} catch (MessagingException e) {
			throw new UserNotFoundException("Unable to fetch user details");
		}
		return isSent;
	}
}
