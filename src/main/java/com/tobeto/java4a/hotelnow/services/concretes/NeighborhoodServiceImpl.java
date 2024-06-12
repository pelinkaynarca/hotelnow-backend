package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.Neighborhood;
import com.tobeto.java4a.hotelnow.repositories.NeighborhoodRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.NeighborhoodService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import com.tobeto.java4a.hotelnow.services.mappers.NeighborhoodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    @Override
    public List<ListNeighborhoodResponse> getAll() {
        List<Neighborhood> neighborhoods = neighborhoodRepository.findAll();
        return neighborhoods.stream()
                .map(NeighborhoodMapper.INSTANCE::listResponseFromNeighborhood)
                .collect(Collectors.toList());
    }

    @Override
    public List<ListNeighborhoodResponse> getByDistrictId(int districtId) {
        List<Neighborhood> neighborhoods = neighborhoodRepository.findByDistrictId(districtId);
        return neighborhoods.stream()
                .map(NeighborhoodMapper.INSTANCE::listResponseFromNeighborhood)
                .collect(Collectors.toList());
    }
}
