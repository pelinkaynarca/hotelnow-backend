package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;

import java.util.List;

public interface RoomTypeImageService {
    List<ListRoomTypeImageResponse> getByRoomTypeId(int roomTypeId);
    ListRoomTypeImageResponse getById(int id);
    AddRoomTypeImageResponse add(AddRoomTypeImageRequest request);
    void delete(int id);
}
