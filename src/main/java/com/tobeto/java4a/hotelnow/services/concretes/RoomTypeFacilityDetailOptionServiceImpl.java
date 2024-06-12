package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityCategory;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailOption;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeFacilityDetailOptionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityCategoryService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailOptionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.AddRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.ListRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailoptions.UpdateRoomTypeFacilityDetailOptionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeFacilityDetailOptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoomTypeFacilityDetailOptionServiceImpl implements RoomTypeFacilityDetailOptionService {

    private final RoomTypeFacilityDetailOptionRepository roomTypeFacilityDetailOptionRepository;
    private final RoomTypeFacilityCategoryService roomTypeFacilityCategoryService;

    @Override
    public List<ListRoomTypeFacilityDetailOptionResponse> getByCategoryId(int categoryId) {

        return roomTypeFacilityDetailOptionRepository.findByCategoryId(categoryId).stream()
                .map(RoomTypeFacilityDetailOptionMapper.INSTANCE::listResponseFromRoomTypeFacilityDetailOption)
                .collect(Collectors.toList());
    }

    @Override
    public AddRoomTypeFacilityDetailOptionResponse add(AddRoomTypeFacilityDetailOptionRequest request) {

        RoomTypeFacilityDetailOption roomTypeFacilityDetailOption = RoomTypeFacilityDetailOptionMapper.INSTANCE.roomTypeFacilityDetailOptionFromAddRequest(request);

        RoomTypeFacilityCategory roomTypeFacilityCategory = roomTypeFacilityCategoryService.getById(request.getCategoryId());

        roomTypeFacilityDetailOption.setRoomTypeFacilityCategory(roomTypeFacilityCategory);

        RoomTypeFacilityDetailOption savedRoomTypeFacilityDetailOption = roomTypeFacilityDetailOptionRepository.save(roomTypeFacilityDetailOption);

        return RoomTypeFacilityDetailOptionMapper.INSTANCE.addResponseFromRoomTypeFacilityDetailOption(savedRoomTypeFacilityDetailOption);
    }

    @Override
    public UpdateRoomTypeFacilityDetailOptionResponse update(UpdateRoomTypeFacilityDetailOptionRequest request) {

        RoomTypeFacilityDetailOption roomTypeFacilityDetailOption = RoomTypeFacilityDetailOptionMapper.INSTANCE.roomTypeFacilityDetailOptionFromUpdateRequest(request);

        RoomTypeFacilityDetailOption savedRoomTypeFacilityDetailOption = roomTypeFacilityDetailOptionRepository.save(roomTypeFacilityDetailOption);

        return RoomTypeFacilityDetailOptionMapper.INSTANCE.updateResponseFromRoomTypeFacilityDetailOption(savedRoomTypeFacilityDetailOption);

    }

    @Override
    public void delete(int id) {
        roomTypeFacilityDetailOptionRepository.deleteById(id);
    }
}
