package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.enums.EmployeeStatus;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StatusDTO {
    private Long id;
    private EmployeeStatus statusName;
}
