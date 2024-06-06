package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.RoomTypeFacilityCategoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.AddRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.AddRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class RoomTypeFacilityCategoryServiceImpl implements RoomTypeFacilityCategoryService {

    private RoomTypeFacilityCategoryRepository roomTypeFacilityCategoryRepository;

    @Override
    public List<ListRoomTypeFacilityCategoryResponse> getAll() { return List.of(); }

    @Override
    public ListRoomTypeFacilityCategoryResponse getById(int id) {
        return null;
    }

    @Override
    public AddRoomTypeFacilityCategoryResponse add(AddRoomTypeFacilityCategoryRequest request) {
        return null;
    }

    @Override
    public UpdateRoomTypeFacilityCategoryResponse update(UpdateRoomTypeFacilityCategoryRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
