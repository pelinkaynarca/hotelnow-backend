package com.tobeto.java4a.hotelnow.controllers;

import com.tobeto.java4a.hotelnow.services.abstracts.BookedRoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.UpdateBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.AddBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.ListBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.UpdateBookedRoomTypeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booked-room-types")
@AllArgsConstructor
public class BookedRoomTypeController{

    private BookedRoomTypeService bookedRoomTypeService;

    @GetMapping("/get-all")
    public List<ListBookedRoomTypeResponse> getAll() {
        return bookedRoomTypeService.getAll();
    }

    @GetMapping("/{id}")
    public ListBookedRoomTypeResponse getById(@PathVariable int id) {
        return bookedRoomTypeService.getById(id);
    }

    @PostMapping("/create-booked-room-type")
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookedRoomTypeResponse add(@RequestBody @Valid AddBookedRoomTypeRequest request) {
        return bookedRoomTypeService.add(request);
    }

    @PutMapping("/update-booked-room-type")
    public UpdateBookedRoomTypeResponse update(@RequestBody @Valid UpdateBookedRoomTypeRequest request) {
        return bookedRoomTypeService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookedRoomTypeService.delete(id);
    }
}
