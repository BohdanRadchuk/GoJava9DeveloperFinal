package com.javanine.finalProject.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "settlement_sheet")
@EqualsAndHashCode
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
    private int workingHours;

    @Column(name="hospital_hours")
    private int hospitalHours;

    @Column(name="holiday_hours")
    private int holidayHours;

    @Column(name="salary")
    private BigDecimal salary;
}
