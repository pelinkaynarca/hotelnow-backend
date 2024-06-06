package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.MainFacilityOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.AddMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.UpdateMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.AddMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.UpdateMainFacilityOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MainFacilityOptionServiceImpl implements MainFacilityOptionService {

    private MainFacilityOptionRepository mainFacilityOptionRepository;

    @Override
    public List<ListMainFacilityOptionResponse> getAll() { return List.of(); }

    @Override
    public ListMainFacilityOptionResponse getById(int id) {
        return null;
    }

    @Override
    public AddMainFacilityOptionResponse add(AddMainFacilityOptionRequest request) {
        return null;
    }

    @Override
    public UpdateMainFacilityOptionResponse update(UpdateMainFacilityOptionRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
