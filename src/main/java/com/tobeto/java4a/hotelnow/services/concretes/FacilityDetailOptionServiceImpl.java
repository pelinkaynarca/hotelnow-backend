package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.FacilityDetailOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.AddFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.UpdateFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.AddFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.UpdateFacilityDetailOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FacilityDetailOptionServiceImpl implements FacilityDetailOptionService {

    private FacilityDetailOptionRepository facilityDetailOptionRepository;

    @Override
    public List<ListFacilityDetailOptionResponse> getByCategoryId(int categoryId) {
        return List.of();
    }

    @Override
    public AddFacilityDetailOptionResponse add(AddFacilityDetailOptionRequest request) {
        return null;
    }

    @Override
    public UpdateFacilityDetailOptionResponse update(UpdateFacilityDetailOptionRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
