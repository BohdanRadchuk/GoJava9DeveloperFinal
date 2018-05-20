package com.javanine.finalProject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    @Column(name="name")
    @ApiModelProperty(notes = "The status name")
    private String name;

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "The status name")
    private List<Position> positions;

    @OneToMany(mappedBy="department", cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "The status name")
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
