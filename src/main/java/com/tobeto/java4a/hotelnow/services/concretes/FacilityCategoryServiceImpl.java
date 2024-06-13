package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityCategory;
import com.tobeto.java4a.hotelnow.repositories.FacilityCategoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.AddFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitycategories.UpdateFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.AddFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.ListFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitycategories.UpdateFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.mappers.FacilityCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacilityCategoryServiceImpl implements FacilityCategoryService {

    private FacilityCategoryRepository facilityCategoryRepository;
    @Override
    public List<ListFacilityCategoryResponse> getAll() {
        List<FacilityCategory> facilityCategories = facilityCategoryRepository.findAll();
        return facilityCategories.stream()
                .map(FacilityCategoryMapper.INSTANCE::listResponseFromFacilityCategory)
                .collect(Collectors.toList());
    }
    @Override
    public FacilityCategory getById(int id) {
        return facilityCategoryRepository.findById(id).orElse(null);
    }
    @Override
    public ListFacilityCategoryResponse getResponseById(int id) {
        FacilityCategory facilityCategory = getById(id);
        return FacilityCategoryMapper.INSTANCE.listResponseFromFacilityCategory(facilityCategory);
    }
    @Override
    public AddFacilityCategoryResponse add(AddFacilityCategoryRequest request) {
        FacilityCategory facilityCategory = FacilityCategoryMapper.INSTANCE.facilityCategoryFromAddRequest(request);

        FacilityCategory savedFacilityCategory = facilityCategoryRepository.save(facilityCategory);
        return FacilityCategoryMapper.INSTANCE.addResponseFromFacilityCategory(savedFacilityCategory);
    }
    @Override
    public UpdateFacilityCategoryResponse update(UpdateFacilityCategoryRequest request) {
       FacilityCategory facilityCategory = FacilityCategoryMapper.INSTANCE.facilityCategoryFromUpdateRequest(request);

       FacilityCategory savedFacilityCategory = facilityCategoryRepository.save(facilityCategory);

       return FacilityCategoryMapper.INSTANCE.updateResponseFromFacilityCategory(savedFacilityCategory);
    }
    @Override
    public void delete(int id) { facilityCategoryRepository.deleteById(id);}
}
