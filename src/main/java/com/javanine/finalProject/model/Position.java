package com.javanine.finalProject.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

/**
 * The class implements a set of methods for working
 * with entities of the {@link Position} class.
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "position")
@EqualsAndHashCode
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "department_id")
    private Long departmentId;
}
