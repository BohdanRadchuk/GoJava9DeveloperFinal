package com.javanine.finalProject.dto;

import lombok.*;
/**
 * The {@link DepartmentDTO} to read a {@link com.javanine.finalProject.model.Department} entity by controller.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
}
