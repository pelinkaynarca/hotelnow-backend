package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeImageResponse {

    private int id;

    private int roomTypeId;

    private String url;
}
