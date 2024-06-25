package com.tobeto.java4a.hotelnow.services.dtos.requests.roombedtypes;

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
public class AddRoomBedTypeRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;
}
