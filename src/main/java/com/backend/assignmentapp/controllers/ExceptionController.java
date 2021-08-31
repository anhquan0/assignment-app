package com.backend.assignmentapp.controllers;


import com.backend.assignmentapp.exceptions.DuplicateException;
import com.backend.assignmentapp.exceptions.InvalidInputException;
import com.backend.assignmentapp.exceptions.NullReferenceException;
import com.backend.assignmentapp.exceptions.ResourceNotFoundException;
import com.backend.assignmentapp.models.CustomError;
import com.backend.assignmentapp.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public ResponseEntity handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity(new CustomError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity handleDuplicationException(DuplicateException e) {
        return new ResponseEntity(new CustomError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity handleNullReferenceException(NullReferenceException e) {
        return new ResponseEntity(new CustomError(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Object> handleFormatException(InvalidInputException e, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessages());
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
