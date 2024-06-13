package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilityOption;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.ListRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionResponse;

import java.util.List;

public interface RoomTypeMainFacilityOptionService {
    List<ListRoomTypeMainFacilityOptionResponse> getAll();
    RoomTypeMainFacilityOption getById(int id);
    AddRoomTypeMainFacilityOptionResponse add(AddRoomTypeMainFacilityOptionRequest request);
    UpdateRoomTypeMainFacilityOptionResponse update(UpdateRoomTypeMainFacilityOptionRequest request);
    void delete(int id);

}
