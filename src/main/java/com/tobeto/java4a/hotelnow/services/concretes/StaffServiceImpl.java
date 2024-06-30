package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.StaffRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.AddStaffRequestForAdmin;
import com.tobeto.java4a.hotelnow.services.dtos.requests.staffs.UpdateStaffRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.AddStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.ListStaffResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.staffs.UpdateStaffResponse;
import com.tobeto.java4a.hotelnow.services.mappers.StaffMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

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
		loggedInUserMustBeManager();
		Staff loggedInStaff = getLoggedInStaff();
		return getByHotelId(loggedInStaff.getHotel().getId());
	}

	@Override
	public AddStaffResponse add(AddStaffRequest request) {
		loggedInUserMustBeManager();
		Staff staff = StaffMapper.INSTANCE.staffFromAddRequest(request);
		String emailOfLoggedInStaff = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(emailOfLoggedInStaff);
		Staff loggedInStaff = getById(loggedInUser.getId());
		staff.setHotel(loggedInStaff.getHotel());
		Staff savedStaff = addStaff(staff);
		return StaffMapper.INSTANCE.addResponseFromStaff(savedStaff);
	}

	@Override
	public AddStaffResponse addForAdmin(AddStaffRequestForAdmin request) {
		loggedInUserMustBeAdmin();
		Staff staff = StaffMapper.INSTANCE.staffFromAddRequestForAdmin(request);
		Staff savedStaff = addStaff(staff);
		return StaffMapper.INSTANCE.addResponseFromStaff(savedStaff);
	}

	@Override
	public UpdateStaffResponse update(UpdateStaffRequest request) {
		loggedInUserMustBeManager();
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
		String emailOfLoggedInStaff = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(emailOfLoggedInStaff);
		Staff loggedInStaff = getById(loggedInUser.getId());
		return loggedInStaff;
	}

	private void loggedInUserMustBeManager() {
		List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.stream().map(r -> Role.valueOf(r.getAuthority())).toList();
		if (!rolesOfLoggedInUser.contains(Role.MANAGER))
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
	}

	private void loggedInUserMustBeAdmin() {
		List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
				.stream().map(r -> Role.valueOf(r.getAuthority())).toList();
		if (!rolesOfLoggedInUser.contains(Role.ADMIN))
			throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
	}
}
