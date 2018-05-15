package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.User;
import java.util.List;

public interface RoleService extends ModelService<Role, Long> {
    Role findByRoleName(String roleName);

    List<User> findAllUsers();
}
