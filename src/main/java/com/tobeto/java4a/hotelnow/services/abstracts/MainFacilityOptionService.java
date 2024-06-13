package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.MainFacilityOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.AddMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityoptions.UpdateMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.AddMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.ListMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityoptions.UpdateMainFacilityOptionResponse;

import java.util.List;

public interface MainFacilityOptionService {
    List<ListMainFacilityOptionResponse> getAll();
    MainFacilityOption getById(int id);
    ListMainFacilityOptionResponse getResponseById(int id);
    AddMainFacilityOptionResponse add(AddMainFacilityOptionRequest request);
    UpdateMainFacilityOptionResponse update(UpdateMainFacilityOptionRequest request);
    void delete(int id);
}
