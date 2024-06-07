package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;

import java.util.List;

public interface RoomTypeFacilityDetailOptionService {

    List<ListRoomTypeFacilityDetailOptionResponse> getByCategoryId(int categoryId);
    AddRoomTypeFacilityDetailOptionResponse add(AddRoomTypeFacilityDetailOptionRequest request);
    UpdateRoomTypeFacilityDetailOptionResponse update(UpdateRoomTypeFacilityDetailOptionRequest request);
    void delete(int id);

}
