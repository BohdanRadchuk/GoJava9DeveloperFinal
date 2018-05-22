package com.javanine.finalProject.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
@EqualsAndHashCode(exclude = "positions")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
    private List<Position> positions;

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
