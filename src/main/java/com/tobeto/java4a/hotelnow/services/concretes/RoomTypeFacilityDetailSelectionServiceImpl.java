package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeFacilityDetailSelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeFacilityDetailSelectionServiceImpl implements RoomTypeFacilityDetailSelectionService {

    private RoomTypeFacilityDetailSelectionRepository roomTypeFacilityDetailSelectionRepository;

    @Override
    public List<ListRoomTypeFacilityDetailSelectionResponse> getAll() {
        return List.of();
    }

    @Override
    public ListRoomTypeFacilityDetailSelectionResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomTypeFacilityDetailSelectionResponse add(AddRoomTypeFacilityDetailSelectionRequest request) {
        return null;
    }

    @Override
    public UpdateRoomTypeFacilityDetailSelectionResponse update(UpdateRoomTypeFacilityDetailSelectionRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
