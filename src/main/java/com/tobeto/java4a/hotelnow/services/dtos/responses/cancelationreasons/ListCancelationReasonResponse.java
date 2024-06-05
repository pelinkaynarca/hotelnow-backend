package com.tobeto.java4a.hotelnow.services.dtos.responses.cancelationreasons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCancelationReasonResponse {

    private int id;

    private String reason;

}
