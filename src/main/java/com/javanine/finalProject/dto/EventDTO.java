package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.enums.EmployeeEvent;
import lombok.*;
/**
 * The {@link EventDTO} to read a {@link com.javanine.finalProject.model.Event} entity by controller.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private EmployeeEvent eventName;
}
