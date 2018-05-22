package com.javanine.finalProject.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    @ManyToOne
    @JoinColumn(name="position_id", nullable=false)
    private Position position;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department.getName() +
                ", position=" + position.getName() +
                ", hourly rate=" + hourlyRate +
                '}';
    }
}
