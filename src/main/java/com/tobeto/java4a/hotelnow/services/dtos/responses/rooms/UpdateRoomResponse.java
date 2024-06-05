package com.tobeto.java4a.hotelnow.services.dtos.responses.rooms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoomResponse {

    private int id;

    private int roomTypeId;

    private int no;

    private boolean available;
}
