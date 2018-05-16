package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.model.Employee;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.repository.DepartmentRepository;
import com.javanine.finalProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<Position> findAllPositions(Long id) {
        Department department = departmentRepository.getOne(id);
        return department.getPositions();
    }

    @Override
    public List<Employee> findAllEmployees(Long id) {
        Department department = departmentRepository.getOne(id);
        return department.getEmployees();
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void update(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}
