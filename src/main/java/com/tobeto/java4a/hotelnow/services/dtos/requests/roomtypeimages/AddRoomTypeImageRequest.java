package com.tobeto.java4a.hotelnow.services.dtos.requests.roomtypeimages;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomTypeImageRequest {

    @Min(value = 1)
    private int roomTypeId;

    private List<MultipartFile> files;
}
