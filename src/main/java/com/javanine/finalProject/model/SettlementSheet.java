package com.javanine.finalProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Table(name = "settlement_sheet")
public class SettlementSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

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
