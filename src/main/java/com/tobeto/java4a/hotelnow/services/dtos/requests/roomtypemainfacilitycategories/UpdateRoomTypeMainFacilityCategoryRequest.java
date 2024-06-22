package com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypemainfacilitycategories;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomTypeMainFacilityCategoryRequest {

    @Min(value = 1)
    private int id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String title;
}
