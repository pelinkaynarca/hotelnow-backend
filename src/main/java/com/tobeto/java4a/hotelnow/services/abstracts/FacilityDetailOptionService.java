package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.AddFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.UpdateFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.AddFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.UpdateFacilityDetailOptionResponse;

import java.util.List;

public interface FacilityDetailOptionService {

    List<ListFacilityDetailOptionResponse> getByCategoryId(int categoryId);
    AddFacilityDetailOptionResponse add(AddFacilityDetailOptionRequest request);
    UpdateFacilityDetailOptionResponse update(UpdateFacilityDetailOptionRequest request);
    void delete(int id);

}
