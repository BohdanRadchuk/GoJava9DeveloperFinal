package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;

/**
 * Interface for service's layer of Departments. Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 *
 */
public interface DepartmentService extends ModelService<DepartmentDTO, Department, Long> {
    /**
     * Get department by id
     * @param name - name of department
     * @return department
     */
    DepartmentDTO findByName(String name);
}
