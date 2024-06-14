package com.tobeto.java4a.hotelnow.services.dtos.responses.rooms;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    private int roomTypeId;

    private int no;

    private boolean available;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer getRoomTypeId() {
        return roomTypeId == 0 ? null : roomTypeId;
    }
}