package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.enums.EmployeeStatus;
import lombok.*;

/**
 * The {@link StatusDTO} to read a {@link com.javanine.finalProject.model.Status} entity by controller.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    private Long id;
    private EmployeeStatus statusName;
}
