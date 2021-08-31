package com.backend.assignmentapp.exceptions;

import com.backend.assignmentapp.models.CustomError;
import lombok.Getter;

import java.util.List;

@Getter
public class InvalidInputException extends RuntimeException {
    private List<CustomError> messages;

    public InvalidInputException(List<CustomError> messages){
        this.messages=messages;
    }

}
