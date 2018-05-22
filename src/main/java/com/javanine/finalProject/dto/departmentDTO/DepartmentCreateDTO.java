package com.javanine.finalProject.dto.departmentDTO;

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
    @Pattern(regexp = RegexpPatterns.PATTERN_STRING_WITH_NUMBERS_LETTERS_AND_DASH,
            message = RegexpPatterns.MESSAGE_STRING_WITH_NUMBERS_LETTERS_AND_DASH)
    @NotNull(message = "name must be not null")
    private String name;
}
