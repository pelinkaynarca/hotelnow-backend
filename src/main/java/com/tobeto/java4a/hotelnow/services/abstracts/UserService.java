package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.services.dtos.requests.users.AddUserRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.users.UpdateUserRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.users.AddUserResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.users.ListUserResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.users.UpdateUserResponse;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    List<ListUserResponse> getAll();
    ListUserResponse getResponseById(int id);
    User getById(int id);
    User getLoggedInUser();
    AddUserResponse add(AddUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    void delete(int id);

}
