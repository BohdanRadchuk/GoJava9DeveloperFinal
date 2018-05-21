package com.javanine.finalProject.dto.dtoRead;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@link EmployeeReadDTO} to read a {@link com.javanine.finalProject.model.Employee} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class EmployeeReadDTO {
    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String firstName;

    @ApiModelProperty(position = 3)
    private String lastName;

    @ApiModelProperty(position = 6)
    private DepartmentReadDTO department;

    @ApiModelProperty(position = 7)
    private UserReadDTO user;

    @ApiModelProperty(position = 8)
    private PositionReadDTO position;
}
