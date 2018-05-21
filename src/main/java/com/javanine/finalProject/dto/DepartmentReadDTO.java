package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The {@link DepartmentReadDTO} to read a {@link com.javanine.finalProject.model.Department} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class DepartmentReadDTO {

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String name;

    @ApiModelProperty(position = 3)
    private List<PositionReadDTO> positions;

    @ApiModelProperty(position = 4)
    private List<EmployeeReadDTO> employees;
}
