package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.District;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    @Mapping(target = "neighborhoodNames", source = "neighborhoodResponses")
    ListDistrictResponse listResponseFromDistrict(District district, List<ListNeighborhoodResponse> neighborhoodResponses);

    default List<String> mapNeighborhoodResponsesToNames(List<ListNeighborhoodResponse> neighborhoodResponses) {
        return neighborhoodResponses.stream()
                .map(ListNeighborhoodResponse::getName)
                .collect(Collectors.toList());
    }

}
