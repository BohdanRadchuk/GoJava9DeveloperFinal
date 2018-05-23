package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;

public interface DepartmentService extends ModelService<DepartmentDTO, Department, Long> {

    DepartmentDTO findByName(String name);
}
