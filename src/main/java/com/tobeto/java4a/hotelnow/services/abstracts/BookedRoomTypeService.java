package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.UpdateBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.AddBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.ListBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.UpdateBookedRoomTypeResponse;

import java.util.List;

public interface BookedRoomTypeService {
    List<ListBookedRoomTypeResponse> getAll();
    ListBookedRoomTypeResponse getById(int id);
    AddBookedRoomTypeResponse add(AddBookedRoomTypeRequest request);
    List<BookedRoomType> addAll(List<BookedRoomType> bookedRoomTypes);
    UpdateBookedRoomTypeResponse update(UpdateBookedRoomTypeRequest request);
    void delete(int id);
}
