package com.shopping.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3187637111473440037L;

	public UserAlreadyRegisteredException(String message) {
		super(message);
	}
}
