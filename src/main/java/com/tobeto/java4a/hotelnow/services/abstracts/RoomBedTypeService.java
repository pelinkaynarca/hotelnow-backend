package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.AddRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.UpdateRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.AddRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.ListRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.UpdateRoomBedTypeResponse;

import java.util.List;

public interface RoomBedTypeService {
    List<ListRoomBedTypeResponse> getAll();
    ListRoomBedTypeResponse getById(int id);
    AddRoomBedTypeResponse add(AddRoomBedTypeRequest request);
    UpdateRoomBedTypeResponse update(UpdateRoomBedTypeRequest request);
    void delete (int id);
}
