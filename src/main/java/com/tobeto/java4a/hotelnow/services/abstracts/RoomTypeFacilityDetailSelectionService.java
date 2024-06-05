package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;

import java.util.List;

public interface RoomTypeFacilityDetailSelectionService {
    List<ListRoomTypeFacilityDetailSelectionResponse> getAll();
    ListRoomTypeFacilityDetailSelectionResponse getById(int id);
    AddRoomTypeFacilityDetailSelectionResponse add(AddRoomTypeFacilityDetailSelectionRequest request);
    UpdateRoomTypeFacilityDetailSelectionResponse update(UpdateRoomTypeFacilityDetailSelectionRequest request);
    void delete(int id);
}
