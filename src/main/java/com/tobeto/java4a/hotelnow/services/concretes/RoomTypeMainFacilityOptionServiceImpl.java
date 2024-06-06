package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeMainFacilityOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.AddRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.ListRoomTypeMainFacilityOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityoptions.UpdateRoomTypeMainFacilityOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RoomTypeMainFacilityOptionServiceImpl implements RoomTypeMainFacilityOptionService {

    private RoomTypeMainFacilityOptionRepository roomTypeMainFacilityOptionRepository;
    @Override
    public List<ListRoomTypeMainFacilityOptionResponse> getAll() { return List.of(); }

    @Override
    public ListRoomTypeMainFacilityOptionResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomTypeMainFacilityOptionResponse add(AddRoomTypeMainFacilityOptionRequest request) {
        return null;
    }

    @Override
    public UpdateRoomTypeMainFacilityOptionResponse update(UpdateRoomTypeMainFacilityOptionRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
