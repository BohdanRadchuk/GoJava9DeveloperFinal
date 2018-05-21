package com.javanine.finalProject.dto.dtoUpdate;

import com.javanine.finalProject.mapper.Entity;
import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The {@link EmployeeUpdateDTO} to update a {@link com.javanine.finalProject.model.Employee} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class EmployeeUpdateDTO {
    @ApiModelProperty(position = 1)
    @NotNull(message = "first name must be not null")
    private String firstName;

    @ApiModelProperty(position = 2)
    @NotNull(message = "last name must be not null")
    private String lastName;

    @Entity(Department.class)
    @ApiModelProperty(required = true, position = 4)
    @NotNull(message = "departmentId must be not null")
    private Long departmentId;

    @Entity(Position.class)
    @ApiModelProperty(required = true, position = 5)
    @NotNull(message = "positionId must be not null")
    private Long positionId;

    @Entity(User.class)
    @ApiModelProperty(required = true, position = 5)
    @NotNull(message = "userId must be not null")
    private Long userId;

    @ApiModelProperty(required = true, position = 6)
    @NotNull(message = "startWorkingDate must be not null")
    private BigDecimal hourlyRate;
}
