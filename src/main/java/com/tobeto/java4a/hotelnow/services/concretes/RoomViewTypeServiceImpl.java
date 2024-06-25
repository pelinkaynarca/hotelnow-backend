package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomViewType;
import com.tobeto.java4a.hotelnow.repositories.RoomViewTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomViewTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.AddRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomviewtypes.UpdateRoomViewTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.AddRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.ListRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomviewtypes.UpdateRoomViewTypeResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomViewTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomViewTypeServiceImpl implements RoomViewTypeService {

    private RoomViewTypeRepository viewTypeRepository;

    @Override
    public List<ListRoomViewTypeResponse> getAll() {
        List<RoomViewType> viewTypes = viewTypeRepository.findAll();
        return viewTypes.stream()
                .map(RoomViewTypeMapper.INSTANCE::listResponseFromRoomViewType)
                .collect(Collectors.toList());
    }

    @Override
    public ListRoomViewTypeResponse getById(int id) {
        RoomViewType viewType = viewTypeRepository.findById(id).orElse(null);
        return RoomViewTypeMapper.INSTANCE.listResponseFromRoomViewType(viewType);
    }

    @Override
    public AddRoomViewTypeResponse add(AddRoomViewTypeRequest request) {
        viewTypeWithSameNameShouldNotExist(request.getName());
        RoomViewType viewType =
                RoomViewTypeMapper.INSTANCE.roomViewTypeFromAddRequest(request);

        viewType = viewTypeRepository.save(viewType);
        return RoomViewTypeMapper.INSTANCE.addResponseFromRoomViewType(viewType);
    }

    @Override
    public UpdateRoomViewTypeResponse update(UpdateRoomViewTypeRequest request) {
        viewTypeWithSameNameShouldNotExistForUpdate(request.getName(), request.getId());
        RoomViewType viewType =
                RoomViewTypeMapper.INSTANCE.roomViewTypeFromUpdateRequest(request);

        viewType = viewTypeRepository.save(viewType);
        return RoomViewTypeMapper.INSTANCE.updateResponseFromRoomViewType(viewType);
    }

    @Override
    public void delete(int id) {
        viewTypeRepository.deleteById(id);
    }

    private void viewTypeWithSameNameShouldNotExistForUpdate(String name, int viewTypeId) {
        Optional<RoomViewType> viewTypeWithSameName  = viewTypeRepository.findByNameIgnoreCase(name);

        if (viewTypeWithSameName.isPresent()) {
            RoomViewType existingViewType = viewTypeWithSameName.get();

            if (existingViewType.getId() != viewTypeId) {
                throw new BusinessException("Aynı isimde başka bir manzara türü zaten var");
            }
        }
    }

    private void viewTypeWithSameNameShouldNotExist(String name) {
        Optional<RoomViewType> viewTypeWithSameName = viewTypeRepository.findByNameIgnoreCase(name);

        if(viewTypeWithSameName.isPresent())
            throw new BusinessException("Aynı isimde bir manzara türü zaten var");
    }
}
