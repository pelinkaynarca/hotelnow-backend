package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeMainFacilitySelectionRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.RoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeMainFacilitySelectionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeMainFacilitySelectionServiceImpl implements RoomTypeMainFacilitySelectionService {

    private RoomTypeMainFacilitySelectionRepository selectionRepository;

    @Override
    public List<ListRoomTypeMainFacilitySelectionResponse> getByRoomTypeId(int roomTypeId) {
        List<RoomTypeMainFacilitySelection> selections = selectionRepository.findByRoomTypeId(roomTypeId);
        return RoomTypeMainFacilitySelectionMapper.INSTANCE.groupListResponses(selections);
    }

    @Override
    public RoomTypeMainFacilitySelectionResponse getById(int id) {
        RoomTypeMainFacilitySelection selection = selectionRepository.findById(id).orElse(null);
        return RoomTypeMainFacilitySelectionMapper.INSTANCE.listResponseFromSelection(selection);
    }

    @Override
    public AddRoomTypeMainFacilitySelectionResponse add(AddRoomTypeMainFacilitySelectionRequest request) {
        RoomTypeMainFacilitySelection selection =
                RoomTypeMainFacilitySelectionMapper.INSTANCE.selectionFromAddRequest(request);
        selection = selectionRepository.save(selection);
        return RoomTypeMainFacilitySelectionMapper.INSTANCE.addResponseFromSelection(selection);
    }

    @Override
    public UpdateRoomTypeMainFacilitySelectionResponse update(UpdateRoomTypeMainFacilitySelectionRequest request) {
        RoomTypeMainFacilitySelection selection =
                RoomTypeMainFacilitySelectionMapper.INSTANCE.selectionFromUpdateRequest(request);
        selection = selectionRepository.save(selection);
        return RoomTypeMainFacilitySelectionMapper.INSTANCE.updateResponseFromSelection(selection);
    }

    @Override
    public void delete(int id) {
        selectionRepository.deleteById(id);
    }

    @Override
    public List<RoomTypeMainFacilitySelectionResponse> getResponse(List<RoomTypeMainFacilitySelection> selections) {
        return selections.stream()
                .map(RoomTypeMainFacilitySelectionMapper.INSTANCE::listResponseFromSelection)
                .collect(Collectors.toList());
    }
}
