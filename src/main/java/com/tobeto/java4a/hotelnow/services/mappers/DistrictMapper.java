package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.District;
import com.tobeto.java4a.hotelnow.entities.concretes.Neighborhood;
import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListDistrictResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = NeighborhoodMapper.class)
public interface DistrictMapper {

    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    @Mapping(target = "neighborhoods", source = "neighborhoods")
    ListDistrictResponse listResponseFromDistrict(District district, List<ListNeighborhoodResponse> neighborhoods);

    default List<ListNeighborhoodResponse> mapNeighborhoodsToListNeighborhoodResponses(List<Neighborhood> neighborhoods) {
        return neighborhoods.stream()
                .map(NeighborhoodMapper.INSTANCE::listResponseFromNeighborhood)
                .collect(Collectors.toList());
    }
}
