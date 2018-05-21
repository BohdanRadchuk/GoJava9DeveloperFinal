package com.javanine.finalProject.dto;

import com.javanine.finalProject.validator.RegexpPatterns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * The {@link DepartmentCreateDTO} to create a {@link com.javanine.finalProject.model.Department} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class DepartmentCreateDTO {

    @ApiModelProperty(position = 1)
    @Pattern(regexp = RegexpPatterns.patternStringWithNumbersLettersAndDash,
            message = RegexpPatterns.messageStringWithNumbersLettersAndDash)
    @NotNull(message = "name must be not null")
    private String name;


}
