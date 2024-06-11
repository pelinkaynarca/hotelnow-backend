package com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails;

public class AuthorizationProblemDetails extends ProblemDetails {

	public AuthorizationProblemDetails(String detail) {
		setDetail(detail);
        setTitle("Authorization Violation");
        setType("AuthorizationException");
	}
}
