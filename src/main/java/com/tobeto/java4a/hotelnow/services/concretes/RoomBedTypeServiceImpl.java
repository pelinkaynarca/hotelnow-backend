package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.BusinessException;
import com.tobeto.java4a.hotelnow.entities.concretes.RoomBedType;
import com.tobeto.java4a.hotelnow.repositories.RoomBedTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.RoomBedTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.AddRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes.UpdateRoomBedTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.AddRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.ListRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roombedtypes.UpdateRoomBedTypeResponse;
import com.tobeto.java4a.hotelnow.services.mappers.RoomBedTypeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoomBedTypeServiceImpl implements RoomBedTypeService {

    private RoomBedTypeRepository bedTypeRepository;

    @Override
    public List<ListRoomBedTypeResponse> getAll() {
        List<RoomBedType> bedTypes = bedTypeRepository.findAll();
        return bedTypes.stream()
                .map(RoomBedTypeMapper.INSTANCE::listResponseFromRoomBedType)
                .collect(Collectors.toList());
    }

    @Override
    public ListRoomBedTypeResponse getById(int id) {
        RoomBedType bedType = bedTypeRepository.findById(id).orElse(null);
        return RoomBedTypeMapper.INSTANCE.listResponseFromRoomBedType(bedType);
    }

    @Override
    public AddRoomBedTypeResponse add(AddRoomBedTypeRequest request) {
        bedTypeWithSameNameShouldNotExist(request.getName());
        RoomBedType bedType =
                RoomBedTypeMapper.INSTANCE.roomBedTypeFromAddRequest(request);

        bedType = bedTypeRepository.save(bedType);
        return RoomBedTypeMapper.INSTANCE.addResponseFromRoomBedType(bedType);
    }

    @Override
    public UpdateRoomBedTypeResponse update(UpdateRoomBedTypeRequest request) {
        bedTypeWithSameNameShouldNotExistForUpdate(request.getName(), request.getId());
        RoomBedType bedType =
                RoomBedTypeMapper.INSTANCE.roomBedTypeFromUpdateRequest(request);

        bedType = bedTypeRepository.save(bedType);
        return RoomBedTypeMapper.INSTANCE.updateResponseFromRoomBedType(bedType);
    }

    @Override
    public void delete(int id) {
        bedTypeRepository.deleteById(id);
    }

    private void bedTypeWithSameNameShouldNotExistForUpdate(String name, int bedTypeId) {
        Optional<RoomBedType> bedTypeWithSameName  = bedTypeRepository.findByNameIgnoreCase(name);

        if (bedTypeWithSameName.isPresent()) {
            RoomBedType existingBedType = bedTypeWithSameName.get();

            if (existingBedType.getId() != bedTypeId) {
                throw new BusinessException("Aynı isimde başka yatak tipi zaten var");
            }
        }
    }

    private void bedTypeWithSameNameShouldNotExist(String name) {
        Optional<RoomBedType> bedTypeWithSameName = bedTypeRepository.findByNameIgnoreCase(name);

        if(bedTypeWithSameName.isPresent())
            throw new BusinessException("Aynı isimde bir yatak tipi zaten var");
    }
}
