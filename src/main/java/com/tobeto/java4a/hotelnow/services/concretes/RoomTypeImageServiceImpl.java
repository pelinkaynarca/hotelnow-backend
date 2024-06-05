package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeImageRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages.AddRoomTypeImageRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.AddRoomTypeImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages.ListRoomTypeImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeImageServiceImpl implements RoomTypeImageService {

    private RoomTypeImageRepository roomTypeImageRepository;

    @Override
    public List<ListRoomTypeImageResponse> getByRoomTypeId(int roomTypeId) {
        return List.of();
    }

    @Override
    public ListRoomTypeImageResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomTypeImageResponse add(AddRoomTypeImageRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
