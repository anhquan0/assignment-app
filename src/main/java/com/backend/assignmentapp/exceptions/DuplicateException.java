package com.backend.assignmentapp.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuplicateException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return this.message;
    }
}
