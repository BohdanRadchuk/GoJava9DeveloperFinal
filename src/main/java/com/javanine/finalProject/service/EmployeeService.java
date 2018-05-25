package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;

/**
 * Interface for service's layer of Employees.Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 */
public interface EmployeeService extends ModelService<EmployeeDTO, Employee, Long> {
}
