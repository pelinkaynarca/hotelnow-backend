package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.FacilityDetailSelectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailSelection;
import com.tobeto.java4a.hotelnow.entities.concretes.Hotel;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.AddFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.facilitydetailselections.UpdateFacilityDetailSelectionRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.AddFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.ListFacilityDetailSelectionResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.facilitydetailselections.UpdateFacilityDetailSelectionResponse;

@Mapper
public interface FacilityDetailSelectionMapper {

	FacilityDetailSelectionMapper INSTANCE = Mappers.getMapper(FacilityDetailSelectionMapper.class);

	@Mapping(target = "optionDescription", source = "facilityDetailOption.description")
	FacilityDetailSelectionResponse listResponseFromFacilityDetailSelection(
			FacilityDetailSelection facilityDetailSelection);

	@Mapping(target = "hotelId", source = "hotel.id")
	ListFacilityDetailSelectionResponse listFromFacilityDetailSelection(
			FacilityDetailSelection facilityDetailSelection);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "display", constant = "true")
	@Mapping(target = "facilityDetailOption.id", source = "request.optionId")
	@Mapping(target = "hotel", source = "hotel")
	FacilityDetailSelection facilityDetailSelectionFromAddRequest(AddFacilityDetailSelectionRequest request,
			Hotel hotel);

	@Mapping(target = "facilityDetailOption", ignore = true)
	@Mapping(target = "hotel", ignore = true)
	FacilityDetailSelection facilityDetailSelectionFromUpdateRequest(UpdateFacilityDetailSelectionRequest request);

	@Mapping(target = "hotelId", source = "hotel.id")
	@Mapping(target = "optionId", source = "facilityDetailOption.id")
	AddFacilityDetailSelectionResponse addResponseFromFacilityDetailSelection(
			FacilityDetailSelection facilityDetailSelection);

	@Mapping(target = "hotelId", source = "hotel.id")
	@Mapping(target = "optionId", source = "facilityDetailOption.id")
	UpdateFacilityDetailSelectionResponse updateResponseFromFacilityDetailSelection(
			FacilityDetailSelection facilityDetailSelection);


	default List<FacilityDetailSelectionResponse> mapSelectionsToResponses(List<FacilityDetailSelection> selections) {
		return selections.stream()
				.map(this::listResponseFromFacilityDetailSelection)
				.collect(Collectors.toList());
	}

	default List<ListFacilityDetailSelectionResponse> groupListResponses(List<FacilityDetailSelection> selections) {
		Map<String, List<FacilityDetailSelection>> groupedByCategory = selections.stream()
				.collect(Collectors.groupingBy(
						selection -> {
							if (selection.getFacilityDetailOption() != null && selection.getFacilityDetailOption().getFacilityCategory() != null) {
								return selection.getHotel().getId() + "-" + selection.getFacilityDetailOption().getFacilityCategory().getTitle();
							} else {
								return "";
							}
						}
				));

		return groupedByCategory.entrySet().stream()
				.map(entry -> {
					String key = entry.getKey();
					if (!key.isEmpty()) {
						String[] keys = key.split("-");
						int hotelId = Integer.parseInt(keys[0]);
						String categoryName = keys[1];
						ListFacilityDetailSelectionResponse response = new ListFacilityDetailSelectionResponse();
						response.setHotelId(hotelId);
						response.setCategoryName(categoryName);
						response.setFacilityDetailSelection(mapSelectionsToResponses(entry.getValue()));
						return response;
					} else {
						return null;
					}
				})
				.filter(response -> response != null)
				.collect(Collectors.toList());
	}
}
