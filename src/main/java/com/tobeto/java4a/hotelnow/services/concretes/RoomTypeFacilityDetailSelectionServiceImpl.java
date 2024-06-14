package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailSelection;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeFacilityDetailSelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.RoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeFacilityDetailSelectionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeFacilityDetailSelectionServiceImpl implements RoomTypeFacilityDetailSelectionService {

    private RoomTypeFacilityDetailSelectionRepository selectionRepository;

    @Override
    public List<ListRoomTypeFacilityDetailSelectionResponse> getByRoomTypeId(int roomTypeId) {
        List<RoomTypeFacilityDetailSelection> selections = selectionRepository.findByRoomTypeId(roomTypeId);
        return RoomTypeFacilityDetailSelectionMapper.INSTANCE.groupListResponses(selections);
    }

    @Override
    public RoomTypeFacilityDetailSelectionResponse getById(int id) {
        RoomTypeFacilityDetailSelection selection = selectionRepository.findById(id).orElse(null);
        return RoomTypeFacilityDetailSelectionMapper.INSTANCE.listResponseSelection(selection);
    }

    @Override
    public AddRoomTypeFacilityDetailSelectionResponse add(AddRoomTypeFacilityDetailSelectionRequest request) {
        RoomTypeFacilityDetailSelection selection =
                RoomTypeFacilityDetailSelectionMapper.INSTANCE.selectionFromAddRequest(request);
        selection = selectionRepository.save(selection);
        return RoomTypeFacilityDetailSelectionMapper.INSTANCE.addResponseFromSelection(selection);
    }

    @Override
    public UpdateRoomTypeFacilityDetailSelectionResponse update(UpdateRoomTypeFacilityDetailSelectionRequest request) {
        RoomTypeFacilityDetailSelection selection =
                RoomTypeFacilityDetailSelectionMapper.INSTANCE.selectionFromUpdateRequest(request);
        selection = selectionRepository.save(selection);
        return RoomTypeFacilityDetailSelectionMapper.INSTANCE.updateResponseFromSelection(selection);
    }

    @Override
    public void delete(int id) {
        selectionRepository.deleteById(id);
    }

    @Override
    public List<RoomTypeFacilityDetailSelectionResponse> getResponse(List<RoomTypeFacilityDetailSelection> selections) {
        return selections.stream()
                .map(RoomTypeFacilityDetailSelectionMapper.INSTANCE::listResponseSelection)
                .collect(Collectors.toList());
    }
}
