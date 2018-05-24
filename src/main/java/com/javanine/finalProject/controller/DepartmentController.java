package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.service.DepartmentService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/department")
@Secured({RoleUtil.ROLE_ADMIN})
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> create(@RequestBody Department department) {
        final DepartmentDTO savedDepartment = departmentService.save(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DepartmentDTO> update(@RequestBody Department department) {
        final DepartmentDTO updated = departmentService.update(department);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<DepartmentDTO> findById(@RequestParam Long departmentId) {
        final DepartmentDTO department = departmentService.findById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<DepartmentDTO> findByName(@RequestParam String name) {
        final DepartmentDTO department = departmentService.findByName(name);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    @Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR})
    public ResponseEntity<List<DepartmentDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<DepartmentDTO> departments = departmentService.findAll(page, limit);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        departmentService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}



