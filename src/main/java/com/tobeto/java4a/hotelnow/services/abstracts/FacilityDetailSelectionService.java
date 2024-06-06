package com.tobeto.java4a.hotelnow.services.abstracts;

import java.util.List;

import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.AddFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.UpdateFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.AddFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.UpdateFacilityDetailSelectionResponse;

public interface FacilityDetailSelectionService {
	
	ListFacilityDetailSelectionResponse getById(int id);
	
	List<ListFacilityDetailSelectionResponse> getByHotelId(int hotelId);
	
	AddFacilityDetailSelectionResponse add(AddFacilityDetailSelectionRequest request);
	
	UpdateFacilityDetailSelectionResponse update(UpdateFacilityDetailSelectionRequest request);
	
	void delete(int id);

}
