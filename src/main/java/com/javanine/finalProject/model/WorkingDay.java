package com.javanine.finalProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "working_day")
@Data
public class WorkingDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
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
