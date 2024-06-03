package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.core.enums.Gender;
import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;




@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role authorities;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
