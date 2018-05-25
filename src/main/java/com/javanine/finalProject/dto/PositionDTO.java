package com.javanine.finalProject.dto;

import lombok.*;

/**
 * The {@link PositionDTO} to read a {@link com.javanine.finalProject.model.Position} entity by controller.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO {
    private Long id;
    private String name;
}
