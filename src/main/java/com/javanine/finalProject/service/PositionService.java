package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.Position;
import java.util.List;

public interface PositionService extends ModelService<Position, Long> {
    Position findByName(String name);

    List<Employee> findAllEmployees();
}
