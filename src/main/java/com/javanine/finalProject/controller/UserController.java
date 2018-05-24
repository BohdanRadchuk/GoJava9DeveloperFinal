package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.UserDTO;
import com.javanine.finalProject.model.User;
import com.javanine.finalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Creating user
     * @param user - user
     * @return saved user
     */
    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody User user) {
        final UserDTO saved = userService.save(user);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    /**
     * Updating user
     * @param user - user
     * @return updated user
     */
    @PutMapping
    public ResponseEntity<UserDTO> update(@RequestBody User user) {
        final UserDTO updated = userService.update(user);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    /**
     *  Getting user by id
     * @param id - id
     * @return user {@link UserDTO}
     */
    @GetMapping("/findOne")
    public ResponseEntity<UserDTO> findById(@RequestParam Long id) {
        final UserDTO userDTO = userService.findById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    /**
     * Getting user by email
     * @param email - email
     * @return user {@link UserDTO}
     */
    @GetMapping("/findByEmail")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
        final UserDTO userDTO = userService.findByEmail(email);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    /**
     * Getting list of users
     * @param page - page of list,starting from 0
     * @param limit - limit of pages
     * @return users
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<UserDTO> users = userService.findAll(page, limit);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    /**
     * Delete user by id
     * @param id - id
     * @return empty value
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
