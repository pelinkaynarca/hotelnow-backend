package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeImage;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;

import java.util.List;

public interface RoomTypeImageService {
    ListRoomTypeImageResponse getByRoomTypeId(int roomTypeId);
    AddRoomTypeImageResponse add(AddRoomTypeImageRequest request);
    void delete(int id);
    List<ListImageResponse> getResponse(List<RoomTypeImage> roomTypeImages);
}
