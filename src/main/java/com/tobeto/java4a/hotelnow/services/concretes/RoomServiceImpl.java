package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.entities.concretes.Room;
import com.tobeto.java4a.hotelnow.repositories.RoomRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.AddRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.rooms.UpdateRoomRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.AddRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.ListRoomResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.rooms.UpdateRoomResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Override
    public List<ListRoomResponse> getResponseByRoomTypeId(int roomTypeId) {
        List<Room> rooms = roomRepository.findByRoomTypeId(roomTypeId);
        return rooms.stream()
                .map(RoomMapper.INSTANCE::listResponseFromRoom)
                .collect(Collectors.toList());
    }

    @Override
    public ListRoomResponse getById(int id) {
        Room room = roomRepository.findById(id).orElse(null);
        return RoomMapper.INSTANCE.listResponseFromRoom(room);
    }

    @Override
    public AddRoomResponse add(AddRoomRequest request) {
        roomWithSameNameShouldNotExist(request.getNo());
        Room room = RoomMapper.INSTANCE.roomFromAddRequest(request);
        room = roomRepository.save(room);

        roomRepository.updateRoomTypeDisplayStatusByRoomId(room.isAvailable(), room.getId());
        return RoomMapper.INSTANCE.addResponseFromRoom(room);
    }

    @Override
    public UpdateRoomResponse update(UpdateRoomRequest request) {
        roomWithSameNameShouldNotExistForUpdate(request.getNo(), request.getId());
        Room room = RoomMapper.INSTANCE.roomFromUpdateRequest(request);
        room = roomRepository.save(room);

        roomRepository.updateRoomTypeDisplayStatusByRoomId(room.isAvailable(), room.getId());
        return RoomMapper.INSTANCE.updateResponseFromRoom(room);
    }

    @Override
    public List<Room> getByRoomTypeId(int roomTypeId) {
        return roomRepository.findByRoomTypeId(roomTypeId);
    }

    @Override
    public void delete(int id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();
            roomRepository.deleteById(id);

            roomRepository.updateRoomTypeDisplayStatusByRoomId(room.isAvailable(), room.getId());
        } else {
            throw new BusinessException("Room not found for id: " + id);
        }
    }

    private void roomWithSameNameShouldNotExistForUpdate(int no, int roomId) {
        Optional<Room> existingRoomWithSameNo = roomRepository.findByNo(no);

        if (existingRoomWithSameNo.isPresent()) {
            Room existingRoom = existingRoomWithSameNo.get();

            if (existingRoom.getId() != roomId) {
                throw new BusinessException("Aynı isimde başka bir oda zaten var");
            }
        }
    }

    private void roomWithSameNameShouldNotExist(int no) {
        Optional<Room> roomWithSameNo = roomRepository.findByNo(no);

        if (roomWithSameNo.isPresent())
            throw new BusinessException("Aynı isimde bir oda zaten var");
    }
}
