package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;

public interface StaffService {
	
	ListStaffResponse getResponseById(int id);
	
	Staff getById(int id);
	
	List<ListStaffResponse> getByHotelId(int hotelId);
	
	/**
	 * get staffs of logged in user's(i.e. staff) hotel
	 * @return staffs
	 */
	List<ListStaffResponse> getStaffsOfHotel();
	
	Staff getLoggedInStaff();
	
	AddStaffResponse add(AddStaffRequest request);
	
	Staff addStaff(Staff staff);
	
	UpdateStaffResponse update(UpdateStaffRequest request);

}
