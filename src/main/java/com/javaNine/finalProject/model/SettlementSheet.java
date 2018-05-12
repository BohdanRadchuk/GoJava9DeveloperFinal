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

    @Column(name="working_days")
    private int workingDays;

    @Column(name="hospital_days")
    private int hospitalDays;

    @Column(name="holiday_days")
    private int holidayDays;

    @Column(name="salary")
    private BigDecimal salary;
}
