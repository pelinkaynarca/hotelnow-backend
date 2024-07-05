package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.UserRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.users.AddUserRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.users.UpdateUserRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.users.AddUserResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.users.ListUserResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.users.UpdateUserResponse;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public List<ListUserResponse> getAll() {
		return List.of();
	}

	@Override
	public ListUserResponse getResponseById(int id) {
		return null;
	}
	
	@Override
	public User getById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public User getLoggedInUser() {
		int idOfLoggedInUser = (int) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		return getById(idOfLoggedInUser);
	}

	@Override
	public AddUserResponse add(AddUserRequest request) {
		return null;
	}

	@Override
	public UpdateUserResponse update(UpdateUserRequest request) {
		return null;
	}

	@Override
	public void delete(int id) {

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByEmailIgnoreCase(username).orElse(null);
	}
}
