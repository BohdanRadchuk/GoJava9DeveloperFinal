package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.enums.EmployeeEvent;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private EmployeeEvent eventName;
}
