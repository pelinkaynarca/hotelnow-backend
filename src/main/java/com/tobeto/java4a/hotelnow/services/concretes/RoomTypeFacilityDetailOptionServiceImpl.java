package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeFacilityDetailOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoomTypeFacilityDetailOptionServiceImpl implements RoomTypeFacilityDetailOptionService {

    private RoomTypeFacilityDetailOptionRepository roomTypeFacilityDetailOptionRepository;

    @Override
    public List<ListRoomTypeFacilityDetailOptionResponse> getByCategoryId(int categoryId) {
        return List.of();
    }

    @Override
    public AddRoomTypeFacilityDetailOptionResponse add(AddRoomTypeFacilityDetailOptionRequest request) {
        return null;
    }

    @Override
    public UpdateRoomTypeFacilityDetailOptionResponse update(UpdateRoomTypeFacilityDetailOptionRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
