package com.tobeto.java4a.hotelnow.services.dtos.responses.roomtypeimages;

import com.tobeto.java4a.hotelnow.services.dtos.responses.files.ListFileResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListRoomTypeImageResponse {

    private int roomTypeId;

    private List<ListFileResponse> photos;
}
