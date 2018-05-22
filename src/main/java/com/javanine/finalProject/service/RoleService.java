package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.RoleDTO;
import com.javanine.finalProject.model.Role;

public interface RoleService extends ModelService<Role, Long> {
    Role findByRoleName(String roleName);

    RoleDTO findDto(Long id);
}
