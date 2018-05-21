package com.javanine.finalProject.dto.dtoRead;

import com.javanine.finalProject.model.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@link UserReadDTO} to read a {@link com.javanine.finalProject.model.User} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class UserReadDTO {
    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String email;

    @ApiModelProperty(position = 3)
    private Role role;
}