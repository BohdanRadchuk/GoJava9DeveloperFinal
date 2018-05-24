package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.EmployeeDTO;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.service.EmployeeService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Creating employee
     * @param employee - employee
     * @return saved employee
     */
    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@RequestBody Employee employee) {
        final EmployeeDTO saved = employeeService.save(employee);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    /**
     * Updating created employee
     * @param employee - employee
     * @return updated employee
     */
    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@RequestBody Employee employee) {
        final EmployeeDTO updated = employeeService.update(employee);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    /**
     * Get employee by id
     * @param id - id
     * @return employee {@link EmployeeDTO}
     */
    @GetMapping("/findOne")
    @Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR, RoleUtil.ROLE_EMPLOYEE})
    public ResponseEntity<EmployeeDTO> findById(@RequestParam Long id) {
        final EmployeeDTO employeeDTO = employeeService.findById(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    /**
     * Getting list of employees
     * @param page - page of list, starts from 0
     * @param limit - limit of pages
     * @return list of employees{@link EmployeeDTO}
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<EmployeeDTO> employeeDTO = employeeService.findAll(page, limit);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    /**
     * Delete employee by id
     * @param id - id
     * @return empty value
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

