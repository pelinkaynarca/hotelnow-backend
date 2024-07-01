package com.tobeto.java4a.hotelnow.services.dtos.responses.mainfacilityselections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListMainFacilitySelectionResponse {

    private int id;
    private int optionId;
    private String optionTitle;
    private boolean display;

}
