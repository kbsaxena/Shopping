package com.shopping.services;

import com.shopping.entities.User;

public interface RegisterService {
	public User save(final User user);
	public void sendValidationLink(final User user);
	public boolean updateUserStatus(final Long id);
	public boolean resendValidationLinkUsingEmail(final String email);
}
