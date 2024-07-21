package com.tobeto.java4a.hotelnow.services.dtos.responses.users;

import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.services.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListUserResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private LocalDate birthDate;

    private Gender gender;

    private Role role;
}
