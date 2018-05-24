package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.repository.EmployeeRepository;
import com.javanine.finalProject.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import static org.springframework.util.Assert.notNull;

/**
 * Service layer {@link Employee,EmployeeService}
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * The method calls repository's method to save employee
     * @param employee - employee
     * @return saved employee
     */
    @Override
    public EmployeeDTO save(Employee employee) {
        notNull(employee, "employee is null");
        final Employee saved = employeeRepository.save(employee);
        log.info("Employee saved");
        return employeeRepository.findInId(saved.getId());

    }

    /**
     * The method calls repository's method to get list of employees
     * @param page - starts from 0
     * @param limit - limit of pages
     * @return list
     */
    @Override
    public List<EmployeeDTO> findAll(int page, int limit) {
        log.info("Found all employees");
        return employeeRepository.findAllDto(PageRequest.of(page, limit));
    }

    /**
     * The method calls repository's method to update employee
     * @param employee - employee
     * @return saved employee
     */
    @Override
    public EmployeeDTO update(Employee employee) {
        notNull(employee, "employee is null");
        final Employee saved = employeeRepository.saveAndFlush(employee);
        log.info("Updated employee");
        return employeeRepository.findInId(saved.getId());
    }

    /**
     * The method calls repository's method to delete employee by id
     * @param id - id
     */
    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("Deleted employee");
        employeeRepository.deleteById(id);
    }

    /**
     * The method calls repository's method to get employee by id
     * @param id - id
     * @return id employee
     */
    @Override
    public EmployeeDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("Found one employee");
        return employeeRepository.findInId(id);
    }
}