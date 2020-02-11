package com.shopping.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4101854904287778601L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
