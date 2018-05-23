package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.repository.EmployeeRepository;
import com.javanine.finalProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(Employee employee) {
        notNull(employee, "employee is null");
        final Employee saved = employeeRepository.save(employee);
        return employeeRepository.findInId(saved.getId());
    }

    @Override
    public List<EmployeeDTO> findAll(int page, int limit) {
        return employeeRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public EmployeeDTO update(Employee employee) {
        notNull(employee, "employee is null");
        final Employee saved = employeeRepository.saveAndFlush(employee);
        return employeeRepository.findInId(saved.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        notNull(id, "id is null");
        return employeeRepository.findInId(id);
    }
}