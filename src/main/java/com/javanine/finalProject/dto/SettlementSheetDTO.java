package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.Employee;
import lombok.*;
import java.math.BigDecimal;

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
