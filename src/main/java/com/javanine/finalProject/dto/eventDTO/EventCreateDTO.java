package com.javanine.finalProject.dto.eventDTO;

import com.javanine.finalProject.validator.RegexpPatterns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * The {@link EventCreateDTO} to create a {@link com.javanine.finalProject.model.Event} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class EventCreateDTO {
    @ApiModelProperty(position = 1)
    @NotNull(message = "This field must be NOT NULL")
    @Pattern(regexp = RegexpPatterns.PATTERN_STRING_WITH_NUMBERS_LETTERS_AND_DASH,
            message = RegexpPatterns.MESSAGE_STRING_WITH_NUMBERS_LETTERS_AND_DASH)
    private String name;
}
