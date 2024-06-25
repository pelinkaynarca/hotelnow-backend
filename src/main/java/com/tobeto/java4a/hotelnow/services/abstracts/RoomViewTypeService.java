package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.AddRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.UpdateRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.AddRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.ListRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.UpdateRoomViewTypeResponse;

import java.util.List;

public interface RoomViewTypeService {
    List<ListRoomViewTypeResponse> getAll();
    ListRoomViewTypeResponse getById(int id);
    AddRoomViewTypeResponse add(AddRoomViewTypeRequest request);
    UpdateRoomViewTypeResponse update(UpdateRoomViewTypeRequest request);
    void delete(int id);
}
