package com.tobeto.java4a.hotelnow.entities.concretes;

import com.tobeto.java4a.hotelnow.entities.abstracts.BaseEntity;
import com.tobeto.java4a.hotelnow.services.enums.Gender;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity implements UserDetails {

	@Column(name = "password" , nullable = false)
	private String password;

	@Column(name = "email" , unique = true)
	private String email;

	@Column(name = "first_name" , nullable = false)
	private String firstName;

	@Column(name = "last_name" , nullable = false)
	private String lastName;

	@Column(name = "phone" , nullable = false)
	private String phone;

	@Column(name = "birth_date" , nullable = false)
	private LocalDate birthDate;

	@Column(name = "role" , nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "gender" , nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Override
	public List<Role> getAuthorities() {
		return List.of(this.role);
	}

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
