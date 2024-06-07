package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.UpdateMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.UpdateMainFacilitySelectionResponse;

import java.util.List;

public interface MainFacilitySelectionService {

    List<ListMainFacilitySelectionResponse> getByHotelId(int hotelId);
    AddMainFacilitySelectionResponse add(AddMainFacilitySelectionRequest request);
    UpdateMainFacilitySelectionResponse update(UpdateMainFacilitySelectionRequest request);
}
