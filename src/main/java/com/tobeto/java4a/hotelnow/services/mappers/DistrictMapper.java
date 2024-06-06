package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.District;
import com.tobeto.java4a.hotelnow.entities.concretes.Neighborhood;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    @Mapping(target = "neighborhoods", source = "neighborhoods")
    ListDistrictResponse listResponseFromDistrict(District district);

    ListNeighborhoodResponse neighborhoodToNeighborhoodResponse(Neighborhood neighborhood);

    List<ListNeighborhoodResponse> neighborhoodsToNeighborhoodResponses(List<Neighborhood> neighborhoods);


}
