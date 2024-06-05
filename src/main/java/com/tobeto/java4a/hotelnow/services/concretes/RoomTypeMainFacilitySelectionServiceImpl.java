package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeMainFacilitySelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomTypeMainFacilitySelectionServiceImpl implements RoomTypeMainFacilitySelectionService {

    private RoomTypeMainFacilitySelectionRepository roomTypeMainFacilitySelectionRepository;

    @Override
    public List<ListRoomTypeMainFacilitySelectionResponse> getAll() {
        return List.of();
    }

    @Override
    public ListRoomTypeMainFacilitySelectionResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomTypeMainFacilitySelectionResponse add(AddRoomTypeMainFacilitySelectionRequest request) {
        return null;
    }

    @Override
    public UpdateRoomTypeMainFacilitySelectionResponse update(UpdateRoomTypeMainFacilitySelectionRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
