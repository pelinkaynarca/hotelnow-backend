package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.AddRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.UpdateRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.AddRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.UpdateRoomResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl  implements RoomService {

    private RoomRepository roomRepository;

    @Override
    public List<ListRoomResponse> getAll() {
        return List.of();
    }

    @Override
    public ListRoomResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomResponse add(AddRoomRequest request) {
        return null;
    }

    @Override
    public UpdateRoomResponse update(UpdateRoomRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
