package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.entities.concretes.BookedRoomType;
import com.tobeto.java4a.hotelnow.repositories.BookedRoomTypeRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.BookedRoomTypeService;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.AddBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.requests.bookedroomtypes.UpdateBookedRoomTypeRequest;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.AddBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.ListBookedRoomTypeResponse;
import com.tobeto.java4a.hotelnow.services.dtos.responses.bookedroomtypes.UpdateBookedRoomTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookedRoomTypeServiceImpl implements BookedRoomTypeService {

    private BookedRoomTypeRepository bookedRoomTypeRepository;

    @Override
    public List<ListBookedRoomTypeResponse> getAll() {
        return List.of();
    }

    @Override
    public ListBookedRoomTypeResponse getById(int id) {
        return null;
    }

    @Override
    public AddBookedRoomTypeResponse add(AddBookedRoomTypeRequest request) {
        return null;
    }

    @Override
    public UpdateBookedRoomTypeResponse update(UpdateBookedRoomTypeRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

	@Override
	public List<BookedRoomType> addAll(List<BookedRoomType> bookedRoomTypes) {
		return bookedRoomTypeRepository.saveAll(bookedRoomTypes);
	}
}
