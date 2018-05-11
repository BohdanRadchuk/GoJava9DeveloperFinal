package com.javanine.finalProject.module;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
}

