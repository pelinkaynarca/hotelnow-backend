package com.tobeto.java4a.hotelnow.services.concretes;

import com.tobeto.java4a.hotelnow.repositories.CancellationReasonRepository;
import com.tobeto.java4a.hotelnow.services.abstracts.CancellationReasonService;
import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CancellationServiceImpl implements CancellationReasonService {

    private CancellationReasonRepository cancellationReasonRepository;

    @Override
    public List<ListCancellationReasonResponse> getAll() { return List.of();}

    @Override
    public ListCancellationReasonResponse getById(int id) {
        return null;

    }
}
