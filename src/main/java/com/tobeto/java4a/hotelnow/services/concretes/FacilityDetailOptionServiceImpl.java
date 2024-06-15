package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityCategory;
import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailOption;
import com.tobeto.java4a.hotelnow.repositories.FacilityDetailOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.FacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.AddFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailoptions.UpdateFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.AddFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.ListFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailoptions.UpdateFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.FacilityDetailOptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FacilityDetailOptionServiceImpl implements FacilityDetailOptionService {

    private final FacilityDetailOptionRepository facilityDetailOptionRepository;
    private final FacilityCategoryService facilityCategoryService;

    @Override
    public ListFacilityDetailOptionResponse getById(int id) {
        FacilityDetailOption facilityDetailOption = facilityDetailOptionRepository.findById(id).orElse(null);
        return FacilityDetailOptionMapper.INSTANCE.listResponseFromFacilityDetailOption(facilityDetailOption);
    }

    @Override
    public List<ListFacilityDetailOptionResponse> getByCategoryId(int categoryId) {
        return facilityDetailOptionRepository.findByCategoryId(categoryId).stream()
                .map(FacilityDetailOptionMapper.INSTANCE::listResponseFromFacilityDetailOption)
                .collect(Collectors.toList());
    }

    @Override
    public AddFacilityDetailOptionResponse add(AddFacilityDetailOptionRequest request) {
        FacilityDetailOption facilityDetailOption = FacilityDetailOptionMapper.INSTANCE.facilityDetailOptionFromAddRequest(request);

        FacilityCategory facilityCategory = facilityCategoryService.getById(request.getCategoryId());

        facilityDetailOption.setFacilityCategory(facilityCategory);

        FacilityDetailOption savedFacilityDetailOption = facilityDetailOptionRepository.save(facilityDetailOption);

        return FacilityDetailOptionMapper.INSTANCE.addResponseFromFacilityDetailOption(savedFacilityDetailOption);

    }

    @Override
    public UpdateFacilityDetailOptionResponse update(UpdateFacilityDetailOptionRequest request) {

        FacilityDetailOption facilityDetailOption = FacilityDetailOptionMapper.INSTANCE.facilityDetailOptionFromUpdateRequest(request);

        FacilityDetailOption savedFacilityDetailOption = facilityDetailOptionRepository.save(facilityDetailOption);

        return FacilityDetailOptionMapper.INSTANCE.updateResponseFromFacilityDetailOption(savedFacilityDetailOption);
    }

    @Override
    public void delete(int id) {
        facilityDetailOptionRepository.deleteById(id);
    }
}
