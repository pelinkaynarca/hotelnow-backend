package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.City;
import com.tobeto.java4a.hotelnow.repositories.CityRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CityService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cities.ListOnlyCityResponse;
import com.tobeto.java4a.hotelnow.services.mappers.CityMapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

	private CityRepository cityRepository;

	@Override
	public List<ListOnlyCityResponse> getAll() {
		List<City> cities = cityRepository.findAll();
		return CityMapper.INSTANCE.listOnlyResponsesFromCities(cities);
	}

	@Override
	public List<ListOnlyCityResponse> getOnlyCitiesByCountryId(int countryId) {
		List<City> cities = cityRepository.findByCountryId(countryId);
		List<ListOnlyCityResponse> listOnlyCityResponses = CityMapper.INSTANCE.listOnlyResponsesFromCities(cities);
		return listOnlyCityResponses;
	}
}
