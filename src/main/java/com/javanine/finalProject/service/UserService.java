package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Role;
import com.javanine.finalProject.model.User;
import java.util.List;

public interface UserService extends ModelService<User, Long> {
    User findByEmail(String email);

    List<Role> findAllRoles();
}
