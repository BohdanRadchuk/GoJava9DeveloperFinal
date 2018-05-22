package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.Employee;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PositionDTO {
    private Long id;
    private String name;
    private String department;
    private Employee employee;
}
