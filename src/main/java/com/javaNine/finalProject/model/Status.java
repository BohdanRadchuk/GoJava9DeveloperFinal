package com.javaNine.finalProject.model;

import com.javaNine.finalProject.model.enums.EmployeeStatus;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "statuses")
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private EmployeeStatus statusName;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + statusName + '\'' +
                '}';
    }
}

