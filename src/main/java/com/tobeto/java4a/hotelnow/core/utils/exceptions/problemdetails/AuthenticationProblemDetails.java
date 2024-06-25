package com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails;

public class AuthenticationProblemDetails extends ProblemDetails{
	public AuthenticationProblemDetails(String detail) {
		setDetail(detail);
        setTitle("Authentication Violation");
        setType("BadCredentialsException");
	}
}
