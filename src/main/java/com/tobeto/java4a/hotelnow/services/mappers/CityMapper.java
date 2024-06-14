package com.tobeto.java4a.hotelnow.services.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tobeto.java4a.hotelnow.entities.concretes.City;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListOnlyCityResponse;

@Mapper
public interface CityMapper {

	CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
	
	List<ListOnlyCityResponse> listOnlyResponsesFromCities(List<City> cities);

}
