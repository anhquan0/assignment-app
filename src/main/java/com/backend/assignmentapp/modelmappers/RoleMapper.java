package com.backend.assignmentapp.modelmappers;

import com.backend.assignmentapp.dtos.requests.RoleRequest;
import com.backend.assignmentapp.dtos.responses.RoleResponse;
import com.backend.assignmentapp.entities.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role convertToEntity(RoleRequest roleRequest) {
        Role role = new Role();
        role.setId(roleRequest.getId());
        role.setName(roleRequest.getName());
        return role;
    }

    public RoleResponse convertToResponse(Role role) {
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setId(role.getId());
        roleResponse.setName(role.getName());
        return roleResponse;
    }
}
