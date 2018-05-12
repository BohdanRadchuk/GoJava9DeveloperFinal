package com.javanine.finalProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "working_days")
@Data
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "hours")
    private int hours;

    @Override
    public String toString() {
        return "WorkingDay{" +
                "id=" + id +
                ", date=" + date +
                ", event=" + event.getEventName() +
                ", employee=" + employee.getLastName() +
                ", hours=" + hours +
                '}';
    }
}
