package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailSelection;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.FacilityDetailSelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.abstracts.StaffService;
import com.tobeto.java4a.hotelnow.services.abstracts.UserService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.AddFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.UpdateFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.AddFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.UpdateFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.FacilityDetailSelectionMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacilityDetailSelectionServiceImpl implements FacilityDetailSelectionService {

	private final FacilityDetailSelectionRepository facilityDetailSelectionRepository;
	private final UserService userService;
	private final StaffService staffService;

	@Override
	public ListFacilityDetailSelectionResponse getById(int id) {
		FacilityDetailSelection facilityDetailSelection = facilityDetailSelectionRepository.findById(id).orElse(null);

		return FacilityDetailSelectionMapper.INSTANCE.listResponseFromFacilityDetailSelection(facilityDetailSelection);
	}

	@Override
	public List<ListFacilityDetailSelectionResponse> getByHotelId(int hotelId) {
		List<FacilityDetailSelection> facilityDetailSelections = facilityDetailSelectionRepository
				.findByHotelId(hotelId);

		return FacilityDetailSelectionMapper.INSTANCE
				.listResponseListFromFacilityDetailSelectionList(facilityDetailSelections);
	}

	@Override
	public AddFacilityDetailSelectionResponse add(AddFacilityDetailSelectionRequest request) {
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User loggedInUser = (User) userService.loadUserByUsername(email);
		Staff staff = staffService.getById(loggedInUser.getId());
		FacilityDetailSelection facilityDetailSelection = FacilityDetailSelectionMapper.INSTANCE
				.facilityDetailSelectionFromAddRequest(request, staff.getHotel());
		FacilityDetailSelection savedFacilityDetailSelection = facilityDetailSelectionRepository
				.save(facilityDetailSelection);
		return FacilityDetailSelectionMapper.INSTANCE
				.addResponseFromFacilityDetailSelection(savedFacilityDetailSelection);
	}

	@Override
	public UpdateFacilityDetailSelectionResponse update(UpdateFacilityDetailSelectionRequest request) {
		FacilityDetailSelection facilityDetailSelection = FacilityDetailSelectionMapper.INSTANCE
				.facilityDetailSelectionFromUpdateRequest(request);

		FacilityDetailSelection savedFacilityDetailSelection = facilityDetailSelectionRepository
				.save(facilityDetailSelection);
		return FacilityDetailSelectionMapper.INSTANCE
				.updateResponseFromFacilityDetailSelection(savedFacilityDetailSelection);
	}

	@Override
	public void delete(int id) {
		facilityDetailSelectionRepository.deleteById(id);
	}

}
