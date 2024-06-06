package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.FacilityCategoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.AddFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.UpdateFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.AddFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.UpdateFacilityCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FacilityCategoryServiceImpl implements FacilityCategoryService {

    private FacilityCategoryRepository facilityCategoryRepository;

    @Override
    public List<ListFacilityCategoryResponse> getAll() { return List.of(); }

    @Override
    public ListFacilityCategoryResponse getById(int id) {
        return null;
    }

    @Override
    public AddFacilityCategoryResponse add(AddFacilityCategoryRequest request) {
        return null;
    }

    @Override
    public UpdateFacilityCategoryResponse update(UpdateFacilityCategoryRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
