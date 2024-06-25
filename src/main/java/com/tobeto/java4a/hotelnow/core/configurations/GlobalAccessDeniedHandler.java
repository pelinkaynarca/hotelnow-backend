package com.tobeto.java4a.hotelnow.core.configurations;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.tobeto.java4a.hotelnow.core.utils.JsonBuilder;
import com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails.AuthenticationProblemDetails;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.services.dtos.responses.BaseResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GlobalAccessDeniedHandler implements AccessDeniedHandler {

	private final JsonBuilder jsonBuilder;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		BaseResponse<AuthenticationProblemDetails> baseResponse = new BaseResponse<AuthenticationProblemDetails>(
				HttpStatus.UNAUTHORIZED.value(), Messages.Error.AUTHENTICATION_VIOLATION,
				new AuthenticationProblemDetails(accessDeniedException.getMessage()));
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().write(jsonBuilder.serialize(baseResponse));
	}
}
