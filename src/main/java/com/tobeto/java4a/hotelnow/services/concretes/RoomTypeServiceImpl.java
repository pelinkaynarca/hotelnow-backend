package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.*;
import com.tobeto.java4a.hotelnow.repositories.RoomTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.*;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.AddRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypes.UpdateRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.images.ListImageResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
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
    private RoomService roomService;

    @Override
    public List<ListRoomTypeResponse> getAll() {
        return roomTypeRepository.findAll().stream()
                .map(this::mapRoomTypeToLisRoomTypeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListRoomTypeResponse> getByHotelId(int hotelId) {
        List<RoomType> roomTypes = roomTypeRepository.findByHotelId(hotelId);
        return roomTypes.stream()
                .map(this::mapRoomTypeToLisRoomTypeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListRoomTypeResponse> getResponseRoomTypeForStaff() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User loggedInUser = (User) userService.loadUserByUsername(email);
        Staff staff = staffService.getById(loggedInUser.getId());
        Hotel hotel = staff.getHotel();
        List<RoomType> roomTypes = hotel.getRoomTypes();
        return roomTypes.stream()
                .map(this::mapRoomTypeToLisRoomTypeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ListRoomTypeResponse getById(int id) {
        RoomType roomType = roomTypeRepository.findById(id).orElse(null);

        List<ListImageResponse> images = roomTypeImageService.getResponse(roomType.getRoomTypeImages());
        List<ListRoomTypeFacilityDetailSelectionResponse> selections =
                roomTypeFacilityDetailSelectionService.getByRoomTypeId(roomType.getId());
        List<Room> rooms = roomService.getByRoomTypeId(roomType.getId());

        return RoomTypeMapper.INSTANCE.listResponse(roomType, images, selections, rooms);
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

    private ListRoomTypeResponse mapRoomTypeToLisRoomTypeResponse(RoomType roomType) {
        List<ListImageResponse> images = roomTypeImageService.getResponse(roomType.getRoomTypeImages());
        List<ListRoomTypeFacilityDetailSelectionResponse> selections =
                roomTypeFacilityDetailSelectionService.getByRoomTypeId(roomType.getId());
        List<Room> rooms = roomService.getByRoomTypeId(roomType.getId());
        return RoomTypeMapper.INSTANCE.listResponse(roomType,images, selections, rooms);
    }
}
