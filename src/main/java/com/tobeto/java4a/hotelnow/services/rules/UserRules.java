package com.tobeto.java4a.hotelnow.services.rules;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRules {

	private UserService userService;

	public UserRules(@Lazy UserService userService) {
		this.userService = userService;
	}

	public void loggedInUserMustBeManager() {
		List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.stream().map(r -> Role.valueOf(r.getAuthority())).toList();
		if (!rolesOfLoggedInUser.contains(Role.MANAGER))
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
	}

	public void loggedInUserMustBeAdmin() {
		List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.stream().map(r -> Role.valueOf(r.getAuthority())).toList();
		if (!rolesOfLoggedInUser.contains(Role.ADMIN))
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
	}

	public void userWithSameEmailShouldNotExist(String email) {
		User user = (User) userService.loadUserByUsername(email);
		if (user != null)
			throw new BusinessException(Messages.Error.USER_WITH_SAME_EMAIL_EXISTS);
	}
	
}
