package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.repositories.StaffRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequestForAdmin;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;
import com.tobeto.java4a.hotelnow.services.mappers.StaffMapper;
import com.tobeto.java4a.hotelnow.services.rules.UserRules;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;
	private final PasswordEncoder passwordEncoder;
	
	private final UserRules userRules;

	@Override
	public ListStaffResponse getResponseById(int id) {
		Staff staff = staffRepository.findById(id).orElse(null);
		return StaffMapper.INSTANCE.listResponseFromStaff(staff);
	}

	@Override
	public List<ListStaffResponse> getByHotelId(int hotelId) {
		List<Staff> staffs = staffRepository.findByHotelId(hotelId);
		return StaffMapper.INSTANCE.listResponsesFromStaffs(staffs);
	}

	@Override
	public List<ListStaffResponse> getStaffsOfHotel() {
		userRules.loggedInUserMustBeManager();
		Staff loggedInStaff = getLoggedInStaff();
		return getByHotelId(loggedInStaff.getHotel().getId());
	}

	@Override
	public AddStaffResponse add(AddStaffRequest request) {
		userRules.loggedInUserMustBeManager();
		Staff staff = StaffMapper.INSTANCE.staffFromAddRequest(request);
		Staff loggedInStaff = getLoggedInStaff();
		staff.setHotel(loggedInStaff.getHotel());
		Staff savedStaff = addStaff(staff);
		return StaffMapper.INSTANCE.addResponseFromStaff(savedStaff);
	}

	@Override
	public AddStaffResponse addForAdmin(AddStaffRequestForAdmin request) {
		userRules.loggedInUserMustBeAdmin();
		Staff staff = StaffMapper.INSTANCE.staffFromAddRequestForAdmin(request);
		Staff savedStaff = addStaff(staff);
		return StaffMapper.INSTANCE.addResponseFromStaff(savedStaff);
	}

	@Override
	public UpdateStaffResponse update(UpdateStaffRequest request) {
		userRules.loggedInUserMustBeManager();
		Staff staff = StaffMapper.INSTANCE.staffFromUpdateRequest(request);
		Staff savedStaff = staffRepository.save(staff);
		return StaffMapper.INSTANCE.updateResponseFromStaff(savedStaff);
	}

	@Override
	public Staff getById(int id) {
		return staffRepository.findById(id).orElse(null);
	}

	private Staff addStaff(Staff staff) {
		staff.setRole(Role.MANAGER);
		staff.setPassword(passwordEncoder.encode(staff.getPassword()));
		Staff savedStaff = staffRepository.save(staff);
		return savedStaff;
	}

	@Override
	public void deleteById(int id) {
		staffRepository.deleteById(id);
	}

	@Override
	public Staff getLoggedInStaff() {
		int idOfLoggedInStaff = (int) SecurityContextHolder.getContext().getAuthentication().getCredentials();
		Staff loggedInStaff = getById(idOfLoggedInStaff);
		return loggedInStaff;
	}
	
}
