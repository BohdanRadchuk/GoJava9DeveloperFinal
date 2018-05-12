package com.javanine.finalProject.model;

import com.javanine.finalProject.model.enums.EmployeeStatus;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "statuses")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private EmployeeStatus statusName;

    @OneToMany(mappedBy="status", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + statusName + '\'' +
                '}';
    }
}

