package com.tobeto.java4a.hotelnow.services.dtos.responses.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import com.tobeto.java4a.hotelnow.services.enums.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private LocalDate birthDate;

    private Gender gender;
}
