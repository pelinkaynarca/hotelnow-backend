package com.tobeto.java4a.hotelnow.services.dtos.requests.hotelimages;

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
public class AddHotelImageRequest {

    private List<MultipartFile> files;

}
