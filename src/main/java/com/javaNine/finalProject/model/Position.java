package com.javaNine.finalProject.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    @OneToMany(mappedBy="position", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
