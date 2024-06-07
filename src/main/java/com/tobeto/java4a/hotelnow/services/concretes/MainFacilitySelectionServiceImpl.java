package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.MainFacilitySelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.MainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.UpdateMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.UpdateMainFacilitySelectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MainFacilitySelectionServiceImpl implements MainFacilitySelectionService {

    private MainFacilitySelectionRepository mainFacilitySelectionRepository;

    @Override
    public List<ListMainFacilitySelectionResponse> getByHotelId(int hotelId) {
        return List.of();
    }

    @Override
    public AddMainFacilitySelectionResponse add(AddMainFacilitySelectionRequest request) {
        return null;
    }

    @Override
    public UpdateMainFacilitySelectionResponse update(UpdateMainFacilitySelectionRequest request) {
        return null;
    }

}
