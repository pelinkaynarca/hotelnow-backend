package com.tobeto.java4a.hotelnow.services.dtos.responses.rooms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomResponse {

    private int id;

    private String roomTypeName;

    private int no;

    private boolean available;
}
