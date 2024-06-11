package com.tobeto.java4a.hotelnow.core.utils.exceptions.types;

import org.springframework.security.access.AccessDeniedException;

public class AuthorizationException extends AccessDeniedException{

	public AuthorizationException(String msg) {
		super(msg);
	}

}
