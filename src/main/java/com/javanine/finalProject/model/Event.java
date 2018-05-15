package com.javanine.finalProject.model;

import com.javanine.finalProject.model.enums.EmployeeEvent;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private EmployeeEvent eventName;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + eventName + '\'' +
                '}';
    }
}

