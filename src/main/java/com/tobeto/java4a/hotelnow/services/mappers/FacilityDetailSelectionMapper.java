package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.FacilityDetailOption;
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

	@Mapping(target = "option.categoryTitle", ignore = true)
	@Mapping(target = "hotelId", source = "hotel.id")
	@Mapping(target = "option", source = "facilityDetailOption")
	ListFacilityDetailSelectionResponse listResponseFromFacilityDetailSelection(
			FacilityDetailSelection facilityDetailSelection);
	
	@Mapping(target = "option.categoryTitle", ignore = true)
	@Mapping(target = "hotelId", source = "hotel.id")
	@Mapping(target = "option", source = "facilityDetailOption")
	List<ListFacilityDetailSelectionResponse> listResponseListFromFacilityDetailSelectionList(
			List<FacilityDetailSelection> facilityDetailSelections);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "hotel", source = "hotel")
	@Mapping(target = "facilityDetailOption", expression = "java( getDefaultFacilityDetailOption(request.getOptionId()) )")
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

	default FacilityDetailOption getDefaultFacilityDetailOption(int optionId) {
		FacilityDetailOption facilityDetailOption = new FacilityDetailOption();
		facilityDetailOption.setId(optionId);
		return facilityDetailOption;
	}

}
