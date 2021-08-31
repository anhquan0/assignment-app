package com.backend.assignmentapp.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourceNotFoundException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
