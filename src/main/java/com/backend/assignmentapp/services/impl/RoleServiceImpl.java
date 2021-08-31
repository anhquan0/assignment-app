package com.backend.assignmentapp.services.impl;

import com.backend.assignmentapp.daos.RoleDao;
import com.backend.assignmentapp.dtos.requests.RoleRequest;
import com.backend.assignmentapp.dtos.responses.RoleResponse;
import com.backend.assignmentapp.entities.Role;
import com.backend.assignmentapp.exceptions.DuplicateException;
import com.backend.assignmentapp.exceptions.InvalidInputException;
import com.backend.assignmentapp.exceptions.NullReferenceException;
import com.backend.assignmentapp.exceptions.ResourceNotFoundException;
import com.backend.assignmentapp.modelmappers.RoleMapper;
import com.backend.assignmentapp.services.RoleService;
import com.backend.assignmentapp.validator.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private CommonValidator commonValidator;

    @Override
    public List<RoleResponse> getAll(String name, int page, int size) {
        List<RoleResponse> roleRes = new ArrayList<>();
        PageRequest paging = PageRequest.of(page, size);
        List<Role> roles = roleDao.findAll();
        List<RoleResponse> roleResponses = roles.stream().map(role -> roleMapper.convertToResponse(role)).collect(Collectors.toList());
        return roleResponses;
    }

    @Override
    public RoleResponse get(Long id) throws ResourceNotFoundException {
        Optional<Role> roleOptional = roleDao.findById(id);
        if(roleOptional.isEmpty()) {
            throw new ResourceNotFoundException("Role not found with id = " + id);
        }
        Role role = roleOptional.get();
        RoleResponse roleResponse = roleMapper.convertToResponse(role);
        return roleResponse;
    }


    @Override
    public RoleResponse save(RoleRequest roleRequest) throws NullReferenceException, DuplicateException, InvalidInputException {
        roleRequest.setName(roleRequest.getName().trim());
        if(roleDao.findDuplicateRoleName(roleRequest.getName()).isPresent()) {
            throw new DuplicateException("Role name already exists");
        }
        if(!commonValidator.checkFormatName(roleRequest.getName()).isEmpty()) {
            throw new InvalidInputException(commonValidator.checkFormatName(roleRequest.getName()));
        }
        Role role = roleMapper.convertToEntity(roleRequest);
        Role saveRole = roleDao.save(role);
        RoleResponse roleResponse = roleMapper.convertToResponse(saveRole);
        return roleResponse;
    }
    @Override
    @Transactional
    public RoleResponse update(Long id, RoleRequest request) throws ResourceNotFoundException, DuplicateException, NullReferenceException, InvalidInputException {
        Optional<Role> roleOptional = roleDao.findById(id);
        if(roleOptional.isEmpty()) {
            throw new ResourceNotFoundException("Role not found with id = " + id);
        }
        if(roleDao.findDuplicateRole(id, request.getName()).isPresent())  {
            throw new DuplicateException("Role name already exists");
        }
        if(!commonValidator.checkFormatName(request.getName()).isEmpty()) {
            throw new InvalidInputException(commonValidator.checkFormatName(request.getName()));
        }
        Role role = roleMapper.convertToEntity(request);
        role.setId(id);
        Role saveRole = roleDao.save(role);
        RoleResponse roleResponse = roleMapper.convertToResponse(saveRole);
        return roleResponse;
    }

    @Override
    public void deleteMulti(List<Long> ids) throws ResourceNotFoundException {
        for(Long id: ids) {
            Optional<Role> roleOptional = roleDao.findById(id);
            if(roleOptional.isEmpty()) {
                throw new ResourceNotFoundException("Role not found with id = " + id);
            }
        }
        roleDao.deleteMultiRoleByIds(ids);
    }
}
