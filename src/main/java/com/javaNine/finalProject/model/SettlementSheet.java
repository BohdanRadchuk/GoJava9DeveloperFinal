package com.javaNine.finalProject.model;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "settlement_sheet")
@Data
public class SettlementSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name="working_hours")
    private int workingHours;

    @Column(name="hospital_hours")
    private int hospitalHours;

    @Column(name="holiday_hours")
    private int holidayHours;

    @Column(name="salary")
    private BigDecimal salary;
}
