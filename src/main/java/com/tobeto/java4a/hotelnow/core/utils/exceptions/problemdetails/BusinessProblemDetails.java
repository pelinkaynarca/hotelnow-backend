package com.tobeto.java4a.hotelnow.core.utils.exceptions.problemdetails;

import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessProblemDetails extends ProblemDetails{

    public BusinessProblemDetails() {
        setDetail(Messages.Error.BAD_REQUEST);
        setTitle("Business Rule Violation");
        setType("BusinessException");
    }
}
