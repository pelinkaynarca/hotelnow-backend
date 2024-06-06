package com.tobeto.java4a.hotelnow.services.abstracts;

import com.tobeto.java4a.hotelnow.services.dtos.responses.cancellationreasons.ListCancellationReasonResponse;

import java.util.List;

public interface CancellationReasonService {

    List<ListCancellationReasonResponse> getAll();

    ListCancellationReasonResponse getById(int id);


}
