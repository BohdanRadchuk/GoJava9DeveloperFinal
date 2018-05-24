package com.javanine.finalProject.model;

import com.javanine.finalProject.model.enums.EmployeeEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
/**
 * The class implements a set of methods for working
 * with entities of the {@link Event} class.
 */
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    @Enumerated(EnumType.STRING)
    private EmployeeEvent eventName;
}

