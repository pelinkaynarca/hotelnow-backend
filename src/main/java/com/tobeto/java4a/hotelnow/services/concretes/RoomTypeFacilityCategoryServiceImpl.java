package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityCategory;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeFacilityCategoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.AddRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.AddRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.ListRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitycategories.UpdateRoomTypeFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.mappers.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeFacilityCategoryServiceImpl implements RoomTypeFacilityCategoryService {

    private RoomTypeFacilityCategoryRepository roomTypeFacilityCategoryRepository;

    @Override
    public List<ListRoomTypeFacilityCategoryResponse> getAll() {
        List<RoomTypeFacilityCategory> categories = roomTypeFacilityCategoryRepository.findAll();
        return categories.stream()
                .map(RoomTypeFacilityCategoryMapper.INSTANCE::listResponseFromRoomTypeFacilityCategory)
                .collect(Collectors.toList());
    }

    @Override
    public RoomTypeFacilityCategory getById(int id) {
        return roomTypeFacilityCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ListRoomTypeFacilityCategoryResponse getResponseById(int id) {
        RoomTypeFacilityCategory roomTypeFacilityCategory = getById(id);
        return RoomTypeFacilityCategoryMapper.INSTANCE.listResponseFromRoomTypeFacilityCategory(roomTypeFacilityCategory);
    }

    @Override
    public AddRoomTypeFacilityCategoryResponse add(AddRoomTypeFacilityCategoryRequest request) {

        RoomTypeFacilityCategory roomTypeFacilityCategory = RoomTypeFacilityCategoryMapper.INSTANCE.roomTypeFacilityCategoryFromAddRequest(request);

        RoomTypeFacilityCategory savedRoomTypeFacilityCategory = roomTypeFacilityCategoryRepository.save(roomTypeFacilityCategory);

        return RoomTypeFacilityCategoryMapper.INSTANCE.addResponseFromRoomTypeFacilityCategory(savedRoomTypeFacilityCategory);
    }

    @Override
    public UpdateRoomTypeFacilityCategoryResponse update(UpdateRoomTypeFacilityCategoryRequest request) {

        RoomTypeFacilityCategory roomTypeFacilityCategory = RoomTypeFacilityCategoryMapper.INSTANCE.roomTypeFacilityCategoryFromUpdateRequest(request);

        RoomTypeFacilityCategory savedRoomTypeFacilityCategory = roomTypeFacilityCategoryRepository.save(roomTypeFacilityCategory);

        return RoomTypeFacilityCategoryMapper.INSTANCE.updateResponseFromRoomTypeFacilityCategory(savedRoomTypeFacilityCategory);
    }

    @Override
    public void delete(int id) {
        roomTypeFacilityCategoryRepository.deleteById(id);
    }
}
