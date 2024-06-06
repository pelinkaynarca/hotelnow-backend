package com.tobeto.java4a.hotelnow.services.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4a.hotelnow.repositories.FacilityDetailSelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.AddFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.UpdateFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.AddFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.UpdateFacilityDetailSelectionResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FacilityDetailSelectionServiceImpl implements FacilityDetailSelectionService {
	
	private FacilityDetailSelectionRepository facilityDetailSelectionRepository;

	@Override
	public ListFacilityDetailSelectionResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ListFacilityDetailSelectionResponse> getByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddFacilityDetailSelectionResponse add(AddFacilityDetailSelectionRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateFacilityDetailSelectionResponse update(UpdateFacilityDetailSelectionRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
