package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;

public interface StaffService {
	
	ListStaffResponse getById(int id);
	
	List<ListStaffResponse> getByHotelId(int hotelId);
	
	AddStaffResponse add(AddStaffRequest request);
	
	UpdateStaffResponse update(UpdateStaffRequest request);

}
