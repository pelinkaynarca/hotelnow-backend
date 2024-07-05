package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.services.dtos.responses.users.ListUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.services.dtos.responses.login.LoginResponse;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	LoginResponse loginResponseFromUser(User user, String token);


	ListUserResponse listResponseFromUser(User user);
}
