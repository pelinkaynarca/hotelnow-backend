package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.repositories.StaffRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {
	
	private StaffRepository staffRepository;

	@Override
	public ListStaffResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListStaffResponse> getByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddStaffResponse add(AddStaffRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateStaffResponse update(UpdateStaffRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
