package com.tobeto.java4a.hotelnow.core.filters;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.tobeto.java4a.hotelnow.core.configurations.fakeusers.FakeUser;
import com.tobeto.java4a.hotelnow.core.services.JwtService;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	private final FakeUser fakeUser;
	private final HandlerExceptionResolver exceptionResolver;

	public JwtFilter(JwtService jwtService, FakeUser fakeUser,
			@Qualifier("handlerExceptionResolver") HandlerExceptionResolver handlerExceptionResolver) {
		this.jwtService = jwtService;
		this.fakeUser = fakeUser;
		this.exceptionResolver = handlerExceptionResolver;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = null;
		List<Role> roles = null;

		if (fakeUser.getEmail() != null && !fakeUser.getEmail().isBlank()) {
			username = fakeUser.getEmail();
			roles = fakeUser.getAuthorities();
			System.out.println("FAKE LOGIN WITH USERNAME (" + username + ") AND ROLE (" + roles.get(0).name() + ")");
		} else {
			String jwtHeader = request.getHeader("Authorization");

			if (jwtHeader != null && jwtHeader.startsWith("Bearer ")) {
				String jwt = jwtHeader.substring(7);
				try {
					jwtService.validateToken(jwt);
				} catch (JwtException e) {//to catch exceptions for invalid tokens(i.e. expired)
					exceptionResolver.resolveException(request, response, null, e);
				}
				username = jwtService.extractUsername(jwt);
				roles = jwtService.extractRoles(jwt).stream().map((roleStr) -> Role.valueOf(roleStr))
						.collect(Collectors.toList());
			}
		}

		if (username != null && roles != null) {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, roles);
			token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(token);
		}

//		try {
		filterChain.doFilter(request, response);
//		} catch (Exception e) {
//		}
	}

}
