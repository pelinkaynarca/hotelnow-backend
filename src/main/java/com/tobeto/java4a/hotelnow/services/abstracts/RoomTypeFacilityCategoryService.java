package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityCategory;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.AddRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.AddRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryResponse;

import java.util.List;

public interface RoomTypeFacilityCategoryService {

    List<ListRoomTypeFacilityCategoryResponse> getAll();

    RoomTypeFacilityCategory getById(int id);

    ListRoomTypeFacilityCategoryResponse getResponseById(int id);

    AddRoomTypeFacilityCategoryResponse add(AddRoomTypeFacilityCategoryRequest request);

    UpdateRoomTypeFacilityCategoryResponse update(UpdateRoomTypeFacilityCategoryRequest request);

    void delete (int id);

}
