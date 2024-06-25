package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomType;
import com.tobeto.java4a.hotelnow.entities.concretes.Staff;
import com.tobeto.java4a.hotelnow.entities.concretes.User;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.*;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.AddRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.ListRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypes.UpdateRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeRepository roomTypeRepository;
    private RoomTypeFacilityDetailSelectionService roomTypeFacilityDetailSelectionService;
    private UserService userService;
    private StaffService staffService;
    private RoomTypeImageService roomTypeImageService;

    @Override
    public List<ListRoomTypeResponse> getAll() {
        List<RoomType> roomTypes = roomTypeRepository.findAll();
        return roomTypes.stream()
                .map(roomType -> {
                    ListRoomTypeResponse response = RoomTypeMapper.INSTANCE.listResponse(roomType);
                    response.setRoomTypeImages(
                            roomTypeImageService.getResponse(roomType.getRoomTypeImages())
                    );
                    response.setRoomTypeFacilityDetailSelections(
                            roomTypeFacilityDetailSelectionService.getByRoomTypeId(roomType.getId())
                    );
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ListRoomTypeResponse> getByHotelId(int hotelId) {
        List<RoomType> roomTypes = roomTypeRepository.findByHotelId(hotelId);
        return roomTypes.stream()
                .map(roomType -> {
                    ListRoomTypeResponse response = RoomTypeMapper.INSTANCE.listResponse(roomType);
                    response.setRoomTypeImages(
                            roomTypeImageService.getResponse(roomType.getRoomTypeImages())
                    );
                    response.setRoomTypeFacilityDetailSelections(
                            roomTypeFacilityDetailSelectionService.getByRoomTypeId(roomType.getId())
                    );
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ListRoomTypeResponse getById(int id) {
        RoomType roomType = roomTypeRepository.findById(id).orElse(null);

        ListRoomTypeResponse response = RoomTypeMapper.INSTANCE.listResponse(roomType);
        assert roomType != null;
        response.setRoomTypeImages(
                roomTypeImageService.getResponse(roomType.getRoomTypeImages())
        );
        response.setRoomTypeFacilityDetailSelections(
                roomTypeFacilityDetailSelectionService.getByRoomTypeId(roomType.getId())
        );
        return response;
    }

    @Override
    public AddRoomTypeResponse add(AddRoomTypeRequest request) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromAddRequest(request, staff.getHotel());
        roomType = roomTypeRepository.save(roomType);
        return RoomTypeMapper.INSTANCE.addResponseFromRoomType(roomType);
    }

    @Override
    public UpdateRoomTypeResponse update(UpdateRoomTypeRequest request) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        RoomType roomType = RoomTypeMapper.INSTANCE.roomTypeFromUpdateRequest(request, staff.getHotel());
        roomType = roomTypeRepository.save(roomType);
        return RoomTypeMapper.INSTANCE.updateResponseFromRoomType(roomType);
    }

    @Override
    public void delete(int id) {
        roomTypeRepository.deleteById(id);
    }
}
