package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityCategory;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.AddFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.UpdateFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.AddFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.UpdateFacilityCategoryResponse;

import java.util.List;

public interface FacilityCategoryService {
    List<ListFacilityCategoryResponse> getAll();

    FacilityCategory getById(int id);

    ListFacilityCategoryResponse getResponseById(int id);

    AddFacilityCategoryResponse add(AddFacilityCategoryRequest request);

    UpdateFacilityCategoryResponse update(UpdateFacilityCategoryRequest request);

    void deleteById(int id);

}
