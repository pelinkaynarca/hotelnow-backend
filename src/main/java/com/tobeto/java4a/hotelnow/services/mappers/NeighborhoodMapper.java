package com.tobeto.java4a.hotelnow.services.mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.Neighborhood;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NeighborhoodMapper {

    NeighborhoodMapper INSTANCE = Mappers.getMapper(NeighborhoodMapper.class);

    ListNeighborhoodResponse listResponseFromNeighborhood(Neighborhood neighborhood);

}
