package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomType;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeFacilityDetailSelectionService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeImageService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeMainFacilitySelectionService;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeRepository roomTypeRepository;
    private RoomTypeFacilityDetailSelectionService roomTypeFacilityDetailSelectionService;
    private RoomTypeMainFacilitySelectionService roomTypeMainFacilitySelectionService;
    private RoomTypeImageService roomTypeImageService;

    @Override
    public List<ListRoomTypeResponse> getAll() {
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        return roomTypes.stream()
                .map(roomType -> {
                    ListRoomTypeResponse response = RoomTypeMapper.INSTANCE.listResponseFromRoomType(roomType);
                    response.setRoomTypeImages(
                            roomTypeImageService.getResponse(roomType.getRoomTypeImages())
                    );
                    response.setRoomTypeFacilityDetailSelections(
                            roomTypeFacilityDetailSelectionService.getResponse(roomType.getRoomTypeFacilityDetailSelections())
                    );
                    response.setRoomTypeMainFacilitySelections(
                            roomTypeMainFacilitySelectionService.getResponse(roomType.getRoomTypeMainFacilitySelections())
                    );
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ListRoomTypeResponse> getByHotelId(int hotelId) {
        return List.of();
    }

    @Override
    public ListRoomTypeResponse getById(int id) {
        RoomType roomType = roomTypeRepository.findById(id).orElse(null);

        ListRoomTypeResponse response = RoomTypeMapper.INSTANCE.listResponseFromRoomType(roomType);
        assert roomType != null;
        response.setRoomTypeImages(
                roomTypeImageService.getResponse(roomType.getRoomTypeImages())
        );
        response.setRoomTypeFacilityDetailSelections(
                roomTypeFacilityDetailSelectionService.getResponse(roomType.getRoomTypeFacilityDetailSelections())
        );
        response.setRoomTypeMainFacilitySelections(
                roomTypeMainFacilitySelectionService.getResponse(roomType.getRoomTypeMainFacilitySelections())
        );
        return response;
    }

    @Override
    public AddRoomTypeResponse add(AddRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromAddRequest(request);
        roomType = roomTypeRepository.save(roomType);
        return RoomTypeMapper.INSTANCE.addResponseFromRoomType(roomType);
    }

    @Override
    public UpdateRoomTypeResponse update(UpdateRoomTypeRequest request) {
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromUpdateRequest(request);
        roomType = roomTypeRepository.save(roomType);
        return RoomTypeMapper.INSTANCE.updateResponseFromRoomType(roomType);
    }

    @Override
    public void delete(int id) {
        roomTypeRepository.deleteById(id);
    }
}
