package com.javanine.finalProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "working_day")
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @ManyToOne
    @JoinColumn(name="status_id", nullable=false)
    private Status status;

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
