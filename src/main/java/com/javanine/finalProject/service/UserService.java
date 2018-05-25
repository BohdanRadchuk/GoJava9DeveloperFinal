package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.User;

/**
 * Interface for service's layer of Users.Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 */
public interface UserService extends ModelService<UserDTO, User, Long> {
    /**
     * Get user by email
     * @param email - email
     * @return user email
     */
    UserDTO findByEmail(String email);
}
