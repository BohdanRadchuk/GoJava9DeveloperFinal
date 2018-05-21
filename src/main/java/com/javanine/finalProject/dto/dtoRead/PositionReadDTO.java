package com.javanine.finalProject.dto;
import com.javanine.finalProject.model.Department;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The {@link PositionReadDTO} to read a {@link com.javanine.finalProject.model.Position} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel

public class PositionReadDTO {

    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String name;

    @ApiModelProperty(position = 3)
    private DepartmentReadDTO department;

}
