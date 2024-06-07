package com.tobeto.java4a.hotelnow.services.dtos.responses.districts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.neighborhoods.ListNeighborhoodResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListDistrictResponse {

    private int id;

    private String name;

    private List<String> neighborhoodNames;

}
