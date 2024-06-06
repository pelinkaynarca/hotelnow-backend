package com.tobeto.java4a.hotelnow.services.dtos.requests.staffs;

import com.tobeto.java4a.hotelnow.services.dtos.requests.users.AddUserRequest;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddStaffRequest extends AddUserRequest {

	@Min(value = 1)
	private int hotelId;

}
