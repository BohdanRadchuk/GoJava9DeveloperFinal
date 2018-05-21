package com.javanine.finalProject.dto.dtoCreate;

import com.javanine.finalProject.mapper.Entity;
import com.javanine.finalProject.model.Department;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

/**
 * The {@link PositionCreateDTO} to create a {@link com.javanine.finalProject.model.Position} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class PositionCreateDTO {
    @ApiModelProperty(position = 1)
    @NotNull(message = "name must be not null")
    private String name;

    @Entity(Department.class)
    @ApiModelProperty(position = 2)
    @NotNull(message = "department must be not null")
    private Long departmentId;
}
