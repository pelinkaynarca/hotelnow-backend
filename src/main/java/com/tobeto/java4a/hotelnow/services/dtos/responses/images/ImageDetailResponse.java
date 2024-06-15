package com.tobeto.java4a.hotelnow.services.dtos.responses.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDetailResponse {

    private String imageName;

    private String pathOrContainerName;
}
