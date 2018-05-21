package com.javanine.finalProject.dto.dtoCreate;

import com.javanine.finalProject.mapper.Entity;
import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.model.Position;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The {@link EmployeeCreateDTO} to create a {@link com.javanine.finalProject.model.Employee} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class EmployeeCreateDTO {
    @ApiModelProperty(required = true, position = 1)
    @NotNull(message = "firstName must be not null")
    private String firstName;

    @ApiModelProperty(required = true, position = 2)
    @NotNull(message = "lastName must be not null")
    private String lastName;

    @ApiModelProperty(required = true, position = 3)
    @NotNull(message = "email must be not null")
    @Email
    private String email;

    @Entity(Department.class)
    @ApiModelProperty(required = true, position = 4)
    @NotNull(message = "department must be not null")
    private Long department;

    @Entity(Position.class)
    @ApiModelProperty(required = true, position = 5)
    @NotNull(message = "positionId must be not null")
    private Long positionId;

    @ApiModelProperty(required = true, position = 6)
    @NotNull(message = "startWorkingDate must be not null")
    private BigDecimal hourlyRate;
}
