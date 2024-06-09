package com.tobeto.java4a.hotelnow.core.filters;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tobeto.java4a.hotelnow.core.configurations.fakeusers.FakeUser;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final FakeUser fakeUser;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = null;
		List<Role> roles = null;

		if (fakeUser != null) {
			username = fakeUser.getEmail();
			roles = fakeUser.getAuthorities();
			System.out.println(
					"FAKE LOGIN WITH USERNAME (" + username + ") AND ROLE (" + roles.get(0).name() + ")");
		}

//		String jwtHeader = request.getHeader("Authorization");
//
//		if (jwtHeader != null && jwtHeader.startsWith("Bearer ")) {
//			String jwt = jwtHeader.substring(7);
//			try {
//				jwtService.validateToken(jwt);
//				String username = jwtService.extractUsername(jwt);
//				int userId = jwtService.extractUserId(jwt);
//				List<Role> roles = jwtService.extractRoles(jwt).stream().map((roleStr) -> Role.valueOf(roleStr))
//						.collect(Collectors.toList());

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, roles);
		token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(token);
//			} catch (JwtException e) {
//				exceptionResolver.resolveException(request, response, null, e);
//			}
//		}
//		try {
		filterChain.doFilter(request, response);
//		} catch (Exception e) {
//		}
	}

}
