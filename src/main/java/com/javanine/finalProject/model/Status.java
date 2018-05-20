package com.javanine.finalProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.javanine.finalProject.model.enums.EmployeeStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "status")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(notes = "The status name")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus statusName;

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + statusName + '\'' +
                '}';
    }
}

