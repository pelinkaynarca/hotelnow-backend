package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.districts.ListOnlyDistrictResponse;

import java.util.List;

public interface DistrictService {

    List<ListOnlyDistrictResponse> getAll();
    // List<ListDistrictResponse> getByCityId(int cityId);
    List<ListOnlyDistrictResponse> getOnlyDistrictsByCityId(int cityId);

}
