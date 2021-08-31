package com.backend.assignmentapp.services;

import com.backend.assignmentapp.dtos.requests.RoleRequest;
import com.backend.assignmentapp.dtos.responses.RoleResponse;
import com.backend.assignmentapp.exceptions.DuplicateException;
import com.backend.assignmentapp.exceptions.InvalidInputException;
import com.backend.assignmentapp.exceptions.NullReferenceException;
import com.backend.assignmentapp.exceptions.ResourceNotFoundException;

import java.util.List;

public interface RoleService {
    List<RoleResponse> getAll(String name, int page, int size);

    RoleResponse save(RoleRequest roleRequest) throws NullReferenceException, DuplicateException, InvalidInputException;

    RoleResponse get(Long id) throws ResourceNotFoundException;

    RoleResponse update(Long id, RoleRequest request) throws ResourceNotFoundException, DuplicateException, NullReferenceException, InvalidInputException;

    void deleteMulti(List<Long> ids) throws ResourceNotFoundException;
}

