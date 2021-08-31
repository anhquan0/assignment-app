package com.backend.assignmentapp.validator;

import com.backend.assignmentapp.models.CustomError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommonValidator {
    public List<CustomError> checkFormatName(String input) {
        List<CustomError> result = new ArrayList<>();
        if(input.isEmpty()) {
            result.add(new CustomError("Name cannot be empty"));
        }
        else {
            if (input.matches("^.*\\d+.*")) {
                result.add(new CustomError("Name cannot contain numbers"));
            }
            if (input.matches("^(\\w+\\s?)*\\s*$")) {
                result.add(new CustomError("Name is not correct"));
            }
            if (input.length() > 45) {
                result.add(new CustomError("Name length cannot greater than 45"));
            }
        }
        return result;
    }
}
