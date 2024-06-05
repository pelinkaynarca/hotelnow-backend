package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;

import java.util.List;

public interface RoomTypeService {
    List<ListRoomTypeResponse> getAll();
    List<ListRoomTypeResponse> getByHotelId(int hotelId);
    ListRoomTypeResponse getById(int id);
    AddRoomTypeResponse add(AddRoomTypeRequest request);
    UpdateRoomTypeResponse update(UpdateRoomTypeRequest request);
    void delete(int id);
}
