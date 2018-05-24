package com.javanine.finalProject.dto;

import lombok.*;
/**
 * The {@link UserDTO} to read a {@link com.javanine.finalProject.model.User} entity by controller.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String password;
}
