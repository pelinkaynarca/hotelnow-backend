package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;

@Mapper
public interface StaffMapper {

	StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

	@Mapping(target = "hotelId", source = "hotel.id")
	ListStaffResponse listResponseFromStaff(Staff staff);

	List<ListStaffResponse> listResponsesFromStaffs(List<Staff> staffs);

	@Mapping(target = "hotelId", source = "hotel.id")
	AddStaffResponse addResponseFromStaff(Staff staff);

	@Mapping(target = "hotelId", source = "hotel.id")
	UpdateStaffResponse updateResponseFromStaff(Staff staff);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", ignore = true)
	@Mapping(target = "hotel", ignore = true)
	Staff staffFromAddRequest(AddStaffRequest addStaffRequest);

	@Mapping(target = "role", ignore = true)
	@Mapping(target = "hotel", ignore = true)
	Staff staffFromUpdateRequest(UpdateStaffRequest updateStaffRequest);

}
