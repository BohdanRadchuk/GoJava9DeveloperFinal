package com.javanine.finalProject.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString
@Table(name = "employee")
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "position_id")
    private Long positionId;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    @Column(name = "user_id")
    private Long userId;

}
