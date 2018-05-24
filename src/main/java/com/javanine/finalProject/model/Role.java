package com.javanine.finalProject.model;

import com.javanine.finalProject.model.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
/**
 * The class implements a set of methods for working
 * with entities of the {@link Role} class.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private UserRole roleName;
}

