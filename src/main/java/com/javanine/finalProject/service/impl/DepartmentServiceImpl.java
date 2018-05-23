package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.repository.DepartmentRepository;
import com.javanine.finalProject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO findByName(String name) {
        hasText(name, "name is empty");
        return departmentRepository.findByNameDto(name);
    }

    @Override
    public DepartmentDTO save(Department department) {
        notNull(department, "department is null");
        final Department savedDepartment = departmentRepository.save(department);
        return departmentRepository.findInId(savedDepartment.getId());
    }

    @Override
    public DepartmentDTO findById(Long id) {
        notNull(id, "id is null");
        return departmentRepository.findInId(id);
    }

    @Override
    public List<DepartmentDTO> findAll(int page, int limit) {
        return departmentRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public DepartmentDTO update(Department department) {
        notNull(department, "department is null");
        final Department updated = departmentRepository.saveAndFlush(department);
        return departmentRepository.findInId(updated.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        departmentRepository.deleteById(id);
    }
}
