package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.mainfacilityselections.AddMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.AddMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections.ListMainFacilitySelectionResponse;

import java.util.List;

public interface MainFacilitySelectionService {

    ListMainFacilitySelectionResponse getResponseById(int id);
    List<ListMainFacilitySelectionResponse> getByHotelId(int hotelId);
    List<ListMainFacilitySelectionResponse> getByHotelIdForStaff();
    List<ListMainFacilitySelectionResponse> getByHotelIdAndDisplay(int hotelId, boolean display);
    List<ListMainFacilitySelectionResponse> getRandomByHotelId(int hotelId);
    AddMainFacilitySelectionResponse add(AddMainFacilitySelectionRequest request);
    // UpdateMainFacilitySelectionResponse update(UpdateMainFacilitySelectionRequest request);
    void deleteById(int id);
}
