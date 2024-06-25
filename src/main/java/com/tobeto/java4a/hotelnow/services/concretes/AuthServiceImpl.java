package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.services.JwtService;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.services.abstracts.AuthService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.login.LoginRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.login.LoginResponse;
import com.tobeto.java4a.hotelnow.services.mappers.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserService userService;
	private final AuthenticationManager authenticationManager;
	private final JwtService jwtService;

	@Override
	public LoginResponse login(LoginRequest request) {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(Messages.Error.BAD_CREDENTIALS);
		}

		User user = (User) userService.loadUserByUsername(request.getEmail());
		Map<String, Object> extraClaims = new HashMap<String, Object>();
		extraClaims.put("userId", user.getId());
		extraClaims.put("firstName", user.getFirstName());
		extraClaims.put("lastName", user.getLastName());
		extraClaims.put("roles",
				user.getAuthorities().stream().map((role) -> role.getAuthority()).collect(Collectors.toList()));
		String token = jwtService.generateToken(user.getUsername(), extraClaims);

		return UserMapper.INSTANCE.loginResponseFromUser(user, token);
	}

}
