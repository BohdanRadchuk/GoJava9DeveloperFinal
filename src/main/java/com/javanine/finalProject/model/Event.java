package com.javanine.finalProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "event")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @Column(name="name")
    @ApiModelProperty(notes = "The event name")
    @Enumerated(EnumType.STRING)
    private EmployeeEvent eventName;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + eventName + '\'' +
                '}';
    }
}

