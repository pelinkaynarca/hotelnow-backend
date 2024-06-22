package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeMainFacilitySelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.AddRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.ListRoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.RoomTypeMainFacilitySelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypemainfacilityselections.UpdateRoomTypeMainFacilitySelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper
public interface RoomTypeMainFacilitySelectionMapper {

    RoomTypeMainFacilitySelectionMapper INSTANCE = Mappers.getMapper(RoomTypeMainFacilitySelectionMapper.class);

    @Mapping(target = "optionDescription", source = "roomTypeMainFacilityOption.description")
    RoomTypeMainFacilitySelectionResponse listResponseFromSelection(RoomTypeMainFacilitySelection selection);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "display", constant = "true")
    @Mapping(target = "roomTypeMainFacilityOption.id", source = "optionId")
    RoomTypeMainFacilitySelection selectionFromAddRequest(AddRoomTypeMainFacilitySelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeMainFacilityOption.id")
    AddRoomTypeMainFacilitySelectionResponse addResponseFromSelection(RoomTypeMainFacilitySelection response);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "roomTypeMainFacilityOption.id", source = "optionId")
    RoomTypeMainFacilitySelection selectionFromUpdateRequest(UpdateRoomTypeMainFacilitySelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeMainFacilityOption.id")
    UpdateRoomTypeMainFacilitySelectionResponse updateResponseFromSelection(RoomTypeMainFacilitySelection response);

    default List<RoomTypeMainFacilitySelectionResponse> mapSelectionsToResponses(List<RoomTypeMainFacilitySelection> selections) {
        return selections.stream()
                .map(this::listResponseFromSelection)
                .collect(Collectors.toList());
    }

    default List<ListRoomTypeMainFacilitySelectionResponse> groupListResponses(List<RoomTypeMainFacilitySelection> selections) {
        Map<String, List<RoomTypeMainFacilitySelection>> groupedByCategory = selections.stream()
                .collect(Collectors.groupingBy(
                        selection -> String.valueOf(selection.getRoomType().getId())
                ));

        return groupedByCategory.entrySet().stream()
                .map(entry -> {
                    String[] keys = entry.getKey().split("-");
                    int roomTypeId = Integer.parseInt(keys[0]);
                    ListRoomTypeMainFacilitySelectionResponse response = new ListRoomTypeMainFacilitySelectionResponse();
                    response.setRoomTypeId(roomTypeId);
                    response.setRoomTypeMainFacilitySelectionResponses(mapSelectionsToResponses(entry.getValue()));
                    return response;
                })
                .collect(Collectors.toList());
    }
}
