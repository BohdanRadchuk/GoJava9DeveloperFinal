package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.Employee;
import lombok.*;
import java.math.BigDecimal;

/**
 * The {@link SettlementSheetDTO} to read a {@link com.javanine.finalProject.model.SettlementSheet} entity by controller.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SettlementSheetDTO {
    private Long id;
    private Employee employee;
    private int year;
    private int month;
    private int workingHours;
    private int hospitalHours;
    private int holidayHours;
    private BigDecimal salary;
}
