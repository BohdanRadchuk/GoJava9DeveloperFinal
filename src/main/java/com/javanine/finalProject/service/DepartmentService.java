package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.Position;
import java.util.List;

public interface DepartmentService extends ModelService<Department, Long> {
    Department findByName(String name);

    List<Position> findAllPositions(Long id);

    List<Employee> findAllEmployees(Long id);

    DepartmentDTO findDto(Long id);
}
