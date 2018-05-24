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
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(Employee employee) {
        notNull(employee, "employee is null");
        final Employee saved = employeeRepository.save(employee);
        log.info("Employee saved");
        return employeeRepository.findInId(saved.getId());

    }

    @Override
    public List<EmployeeDTO> findAll(int page, int limit) {
        log.info("Found all employees");
        return employeeRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public EmployeeDTO update(Employee employee) {
        notNull(employee, "employee is null");
        final Employee saved = employeeRepository.saveAndFlush(employee);
        log.info("Updated employee");
        return employeeRepository.findInId(saved.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("Deleted employee");
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("Found one employee");
        return employeeRepository.findInId(id);
    }
}