package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilityCategory;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeMainFacilityCategoryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.AddRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.ListRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilitycategories.UpdateRoomTypeMainFacilityCategoryResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeMainFacilityCategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeMainFacilityCategoryServiceImpl implements RoomTypeMainFacilityCategoryService {

    private RoomTypeMainFacilityCategoryRepository categoryRepository;

    @Override
    public List<ListRoomTypeMainFacilityCategoryResponse> getAll() {
        List<RoomTypeMainFacilityCategory> categories = categoryRepository.findAll();
        return categories.stream()
                .map(RoomTypeMainFacilityCategoryMapper.INSTANCE::listResponseFromRoomTypeMainFacilityCategory)
                .collect(Collectors.toList());
    }

    @Override
    public ListRoomTypeMainFacilityCategoryResponse getById(int id) {
        RoomTypeMainFacilityCategory category = categoryRepository.findById(id).orElse(null);
        return RoomTypeMainFacilityCategoryMapper.INSTANCE.listResponseFromRoomTypeMainFacilityCategory(category);
    }

    @Override
    public AddRoomTypeMainFacilityCategoryResponse add(AddRoomTypeMainFacilityCategoryRequest request) {
        RoomTypeMainFacilityCategory category =
                RoomTypeMainFacilityCategoryMapper.INSTANCE.roomTypeMainFacilityCategoryFromAddRequest(request);

        category = categoryRepository.save(category);
        return RoomTypeMainFacilityCategoryMapper.INSTANCE.addResponseFromRoomTypeMainFacilityCategory(category);
    }

    @Override
    public UpdateRoomTypeMainFacilityCategoryResponse update(UpdateRoomTypeMainFacilityCategoryRequest request) {
        RoomTypeMainFacilityCategory category =
                RoomTypeMainFacilityCategoryMapper.INSTANCE.roomTypeMainFacilityCategoryFromUpdateRequest(request);

        category = categoryRepository.save(category);
        return RoomTypeMainFacilityCategoryMapper.INSTANCE.updateResponseFromRoomTypeMainFacilityCategory(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
