package com.backend.assignmentapp.controllers;

import com.backend.assignmentapp.dtos.requests.RoleRequest;
import com.backend.assignmentapp.dtos.responses.RoleResponse;
import com.backend.assignmentapp.exceptions.DuplicateException;
import com.backend.assignmentapp.exceptions.InvalidInputException;
import com.backend.assignmentapp.exceptions.NullReferenceException;
import com.backend.assignmentapp.exceptions.ResourceNotFoundException;
import com.backend.assignmentapp.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAll(@RequestParam(required = false) String name,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "3") int size) {
        List<RoleResponse> roleResponses = roleService.getAll(name, page, size);
        return new ResponseEntity<>(roleResponses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponse> create(@RequestBody RoleRequest roleRequest) throws NullReferenceException, DuplicateException, InvalidInputException {
        RoleResponse saveRoleResponse = roleService.save(roleRequest);
        return new ResponseEntity<RoleResponse>(saveRoleResponse, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleResponse> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        RoleResponse roleResponse = roleService.get(id);
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<RoleResponse> updateById(@PathVariable(value = "id") Long id, @RequestBody RoleRequest roleRequest) throws ResourceNotFoundException,  NullReferenceException, InvalidInputException, DuplicateException {
        RoleResponse updateRole = roleService.update(id, roleRequest);
        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteMultiByIds(@RequestParam("ids") List<Long> ids) throws ResourceNotFoundException {
        roleService.deleteMulti(ids);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
