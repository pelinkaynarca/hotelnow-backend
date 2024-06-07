package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.NeighborhoodRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.NeighborhoodService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private NeighborhoodRepository neighborhoodRepository;

    @Override
    public List<ListNeighborhoodResponse> getAll() {
        return List.of();
    }

    @Override
    public List<ListNeighborhoodResponse> getByDistrictId(int districtId) {
        return List.of();
    }
}
