package com.shopping.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shopping.Constants;
import com.shopping.entities.Customer;
import com.shopping.entities.Phone;
import com.shopping.entities.User;
import com.shopping.entities.UserState;
import com.shopping.repositories.UserRepository;

public class RegisterServiceTest {
	
	@InjectMocks
	private RegisterServiceImpl registerService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void registerUserSuccessfully() {
		Phone phone = new Phone();
		phone.setCountryCode(Constants.COUNTRY_CODE);
		phone.setMobileNumber(Constants.MOBILE_NUMBER);
		Customer customer = new Customer();
		customer.setFullName(Constants.FULL_NAME);
		customer.setEmail(Constants.EMAIL);
		customer.setDob(Constants.DOB);
		customer.setPrimaryPhoneNumber(phone);
		User user = new User();
		user.setCustomer(customer);
		user.setUsername(Constants.USERNAME);
		user.setPassword(Constants.PASSWORD);
		user.setUserState(UserState.NEW);
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		when(passwordEncoder.encode(Mockito.anyString())).thenReturn(Constants.ENCODED_PASSWORD);
		
		User result = registerService.save(user);
		
		assertNotNull(result);
		assertEquals(result.getUsername(), user.getUsername());
		assertEquals(result.getPassword(), user.getPassword());
		assertEquals(result.getUserState(), user.getUserState());
		assertNotNull(result.getCustomer());
		assertEquals(result.getCustomer().getFullName(), user.getCustomer().getFullName());
		assertEquals(result.getCustomer().getEmail(), user.getCustomer().getEmail());
		assertEquals(result.getCustomer().getDob(), user.getCustomer().getDob());
		assertNotNull(result.getCustomer().getPrimaryPhoneNumber());
		assertEquals(result.getCustomer().getPrimaryPhoneNumber().getCountryCode(), user.getCustomer().getPrimaryPhoneNumber().getCountryCode());
		assertEquals(result.getCustomer().getPrimaryPhoneNumber().getMobileNumber(), user.getCustomer().getPrimaryPhoneNumber().getMobileNumber());
	}
}
