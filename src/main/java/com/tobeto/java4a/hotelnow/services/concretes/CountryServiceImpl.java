package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.CountryRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CountryService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.countries.ListCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;
    @Override
    public List<ListCountryResponse> getAll() {return List.of(); }
}
