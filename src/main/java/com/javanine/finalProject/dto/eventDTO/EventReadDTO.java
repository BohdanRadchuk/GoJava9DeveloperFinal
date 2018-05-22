package com.javanine.finalProject.dto.eventDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The {@link EventReadDTO} to read a {@link com.javanine.finalProject.model.Event} entity by Rest Controller.
 */

@Getter
@Setter
@ApiModel
public class EventReadDTO {
    @ApiModelProperty(position = 1)
    private Long id;

    @ApiModelProperty(position = 2)
    private String name;
}
