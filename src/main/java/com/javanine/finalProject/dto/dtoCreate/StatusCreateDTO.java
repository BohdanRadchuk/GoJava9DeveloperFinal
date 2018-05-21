package com.javanine.finalProject.dto.dtoCreate;

import com.javanine.finalProject.validator.RegexpPatterns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * The {@link StatusCreateDTO} to create a {@link com.javanine.finalProject.model.Status} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class StatusCreateDTO {
    @ApiModelProperty(position = 1)
    @NotNull(message = "This field must be NOT NULL")
    @Pattern(regexp = RegexpPatterns.patternStringWithNumbersLettersAndDash,
            message = RegexpPatterns.messageStringWithNumbersLettersAndDash)
    private String name;
}
