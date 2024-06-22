package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.ListRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryResponse;

import java.util.List;

public interface RoomTypeMainFacilityCategoryService {

    List<ListRoomTypeMainFacilityCategoryResponse> getAll();

    ListRoomTypeMainFacilityCategoryResponse getById(int id);

    AddRoomTypeMainFacilityCategoryResponse add(AddRoomTypeMainFacilityCategoryRequest request);

    UpdateRoomTypeMainFacilityCategoryResponse update(UpdateRoomTypeMainFacilityCategoryRequest request);

    void delete (int id);

}
