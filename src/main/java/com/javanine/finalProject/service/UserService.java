package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.User;

public interface UserService extends ModelService<UserDTO, User, Long> {

    UserDTO findByEmail(String email);
}
