package com.javanine.finalProject.model;

import com.javanine.finalProject.model.enums.EmployeeStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "status")
@EqualsAndHashCode
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus statusName;
}

