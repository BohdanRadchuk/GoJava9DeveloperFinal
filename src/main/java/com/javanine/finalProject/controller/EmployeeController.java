package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody Employee employee) {
        final EmployeeDTO saved = employeeService.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody Employee employee) {
        final EmployeeDTO updated = employeeService.update(employee);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<EmployeeDTO> findById(@RequestParam Long id) {
        final EmployeeDTO employeeDTO = employeeService.findById(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<EmployeeDTO> employeeDTO = employeeService.findAll(page, limit);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

