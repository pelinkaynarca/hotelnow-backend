package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.RoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;

import java.util.List;

public interface RoomTypeMainFacilitySelectionService {
    List<ListRoomTypeMainFacilitySelectionResponse> getByRoomTypeId(int roomTypeId);
    RoomTypeMainFacilitySelectionResponse getById(int id);
    AddRoomTypeMainFacilitySelectionResponse add(AddRoomTypeMainFacilitySelectionRequest request);
    UpdateRoomTypeMainFacilitySelectionResponse update(UpdateRoomTypeMainFacilitySelectionRequest request);
    void delete(int id);
    List<RoomTypeMainFacilitySelectionResponse>  getResponse(List<RoomTypeMainFacilitySelection> selections);
}
