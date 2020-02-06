package com.shopping.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.shopping.Constants;
import com.shopping.entities.User;
import com.shopping.entities.UserState;
import com.shopping.repositories.UserRepository;

public class LoginServiceImplTest implements Constants {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	LoginServiceImpl loginService;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public final void testLoginWithValidCredentials() {
		User user = new User();
		user.setId(1L);
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setUserState(UserState.ACTIVE);
		
		when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));
		
		boolean userResponse = loginService.login(USERNAME, PASSWORD);
		
		assertTrue(userResponse);
		verify(userRepository, times(1)).findByUsername(Mockito.anyString());
		
	}
	
	@Test
	public final void testLoginWithInValidCredentials() {
		User user = new User();
		user.setId(1L);
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setUserState(UserState.ACTIVE);
		
		when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(user));
		
		boolean userResponse = loginService.login(USERNAME, USERNAME);
		
		assertFalse(userResponse);
		verify(userRepository, times(1)).findByUsername(Mockito.anyString());
		
	}
	
	@Test
	public final void testLoginWithInValidUser() {
		User user = new User();
		user.setId(1L);
		user.setUsername(USERNAME);
		user.setPassword(PASSWORD);
		user.setUserState(UserState.ACTIVE);
		
		when(userRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.empty());
		
		Exception exception = assertThrows(RuntimeException.class, ()-> loginService.login(ADMIN, PASSWORD));
		
		assertEquals(USER_NOT_FOUND, exception.getMessage());
		verify(userRepository, times(1)).findByUsername(Mockito.anyString());
	}
}
