package com.shopping.exceptions;

public class InvalidDetailsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3187637111473440037L;

	public InvalidDetailsException(String message) {
		super(message);
	}
}
