package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.RoomTypeFacilityDetailSelection;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.AddRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.ListRoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.RoomTypeFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypefacilitydetailselections.UpdateRoomTypeFacilityDetailSelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Mapper
public interface RoomTypeFacilityDetailSelectionMapper {

    RoomTypeFacilityDetailSelectionMapper INSTANCE = Mappers.getMapper(RoomTypeFacilityDetailSelectionMapper.class);


    @Mapping(target = "optionDescription", source = "roomTypeFacilityDetailOption.description")
    RoomTypeFacilityDetailSelectionResponse listResponseSelection(RoomTypeFacilityDetailSelection selection);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "display", constant = "true")
    @Mapping(target = "roomTypeFacilityDetailOption.id", source = "optionId")
    RoomTypeFacilityDetailSelection selectionFromAddRequest(AddRoomTypeFacilityDetailSelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeFacilityDetailOption.id")
    AddRoomTypeFacilityDetailSelectionResponse addResponseFromSelection(RoomTypeFacilityDetailSelection roomTypeFacilityDetailSelection);

    @Mapping(target = "roomType.id", source = "roomTypeId")
    @Mapping(target = "roomTypeFacilityDetailOption.id", source = "optionId")
    RoomTypeFacilityDetailSelection selectionFromUpdateRequest(UpdateRoomTypeFacilityDetailSelectionRequest request);

    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "optionId", source = "roomTypeFacilityDetailOption.id")
    UpdateRoomTypeFacilityDetailSelectionResponse updateResponseFromSelection(RoomTypeFacilityDetailSelection roomTypeFacilityDetailSelection);

    default List<RoomTypeFacilityDetailSelectionResponse> mapSelectionsToResponses(List<RoomTypeFacilityDetailSelection> selections) {
        return selections.stream()
                .map(this::listResponseSelection)
                .collect(Collectors.toList());
    }

    default List<ListRoomTypeFacilityDetailSelectionResponse> groupListResponses(List<RoomTypeFacilityDetailSelection> selections) {
        Map<String, List<RoomTypeFacilityDetailSelection>> groupedByCategory = selections.stream()
                .collect(Collectors.groupingBy(
                        selection -> selection.getRoomType().getId() + "-" + selection.getRoomTypeFacilityDetailOption().getRoomTypeFacilityCategory().getTitle()
                ));

        return groupedByCategory.entrySet().stream()
                .map(entry -> {
                    String[] keys = entry.getKey().split("-");
                    int roomTypeId = Integer.parseInt(keys[0]);
                    String categoryName = keys[1];
                    ListRoomTypeFacilityDetailSelectionResponse response = new ListRoomTypeFacilityDetailSelectionResponse();
                    response.setRoomTypeId(roomTypeId);
                    response.setCategoryName(categoryName);
                    response.setRoomTypeFacilityDetailSelectionResponses(mapSelectionsToResponses(entry.getValue()));
                    return response;
                })
                .collect(Collectors.toList());
    }
}
