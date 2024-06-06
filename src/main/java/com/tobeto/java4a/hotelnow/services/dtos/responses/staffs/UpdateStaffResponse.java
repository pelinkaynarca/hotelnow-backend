package com.tobeto.java4a.hotelnow.services.dtos.responses.staffs;

import com.tobeto.java4a.hotelnow.services.dtos.responses.users.UpdateUserResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStaffResponse extends UpdateUserResponse {

	private int hotelId;

}
