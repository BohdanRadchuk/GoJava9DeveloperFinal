package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.User;
import lombok.*;
import java.math.BigDecimal;

/**
 * The {@link EmployeeDTO} to read a {@link com.javanine.finalProject.model.Employee} entity by controller.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String department;
    private String position;
    private BigDecimal hourlyRate;
    private User user;
}
