package com.javanine.finalProject.module;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table (name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private BigDecimal salary;

    //private Set<>
}
