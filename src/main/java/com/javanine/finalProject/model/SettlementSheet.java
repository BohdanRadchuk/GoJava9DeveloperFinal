package com.javanine.finalProject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "settlement_sheet")
public class SettlementSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column (name="year")
    private int year;

    @Column(name="month")
    private int month;

    @Column(name="working_hours")
    private BigDecimal workingHours;

    @Column(name="hospital_hours")
    private BigDecimal hospitalHours;

    @Column(name="holiday_hours")
    private BigDecimal holidayHours;

    @Column(name="salary")
    private BigDecimal salary;
}
