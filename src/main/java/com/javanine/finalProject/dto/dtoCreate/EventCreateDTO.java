package com.javanine.finalProject.dto;

import com.javanine.finalProject.validator.RegexpPatterns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * The {@link EventCreateDTO} to create a {@link com.javanine.finalProject.model.Event} entity by Rest Controller.
 */
@Getter
@Setter
@ApiModel
public class EventCreateDTO {

    @ApiModelProperty(position = 1)
    @NotNull(message = "This field must be NOT NULL")
    @Pattern(regexp = RegexpPatterns.patternStringWithNumbersLettersAndDash,
            message = RegexpPatterns.messageStringWithNumbersLettersAndDash)
    private String name;

}
