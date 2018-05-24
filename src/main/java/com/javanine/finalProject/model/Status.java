package com.javanine.finalProject.model;

import com.javanine.finalProject.model.enums.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
/**
 * The class implements a set of methods for working
 * with entities of the {@link Status} class.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus statusName;
}

