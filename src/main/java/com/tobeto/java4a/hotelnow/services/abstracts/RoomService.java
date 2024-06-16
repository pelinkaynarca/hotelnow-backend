package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.AddRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.UpdateRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.AddRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.UpdateRoomResponse;

import java.util.List;

public interface RoomService {
    List<ListRoomResponse> getResponseByRoomTypeId (int roomTypeId);
    ListRoomResponse getById(int id);
    AddRoomResponse add(AddRoomRequest request);
    UpdateRoomResponse update(UpdateRoomRequest request);
    List<Room> getByRoomTypeId (int roomTypeId);
    void delete(int id);
}