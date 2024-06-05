package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<ListRoomTypeResponse> getAll() {
        return List.of();
    }

    @Override
    public List<ListRoomTypeResponse> getByHotelId(int hotelId) {
        return List.of();
    }

    @Override
    public ListRoomTypeResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomTypeResponse add(AddRoomTypeRequest request) {
        return null;
    }

    @Override
    public UpdateRoomTypeResponse update(UpdateRoomTypeRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
