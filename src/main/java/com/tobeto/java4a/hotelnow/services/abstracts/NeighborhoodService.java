package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;

import java.util.List;

public interface NeighborhoodService {

    List<ListNeighborhoodResponse> getAll();
    List<ListNeighborhoodResponse> getByDistrictId(int districtId);

}
