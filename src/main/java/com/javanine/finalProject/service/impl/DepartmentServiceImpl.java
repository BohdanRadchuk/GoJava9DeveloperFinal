package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
import com.javanine.finalProject.repository.DepartmentRepository;
import com.javanine.finalProject.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

/**
 * Service layer {@link DepartmentService}
 */

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * The method calls repository's method to find a department by name
     * @param name - name
     * @return name of department
     */
    @Override
    public DepartmentDTO findByName(String name) {
        hasText(name, "name is empty");
        log.info("Found department by name");
        return departmentRepository.findByNameDto(name);
    }

    /**
     * The method calls repository's method to save a department
     * @param department - department
     * @return saved department
     */
    @Override
    public DepartmentDTO save(Department department) {
        notNull(department, "department is null");
        final Department savedDepartment = departmentRepository.save(department);
        log.info("Department saved");
        return departmentRepository.findInId(savedDepartment.getId());
    }

    /**
     * The method calls repository's method to find department by id
     * @param id - id
     * @return id department
     */
    @Override
    public DepartmentDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("found one department");
        return departmentRepository.findInId(id);
    }

    /**
     * The method calls repository's method to get list of departments
     * @param page - starts from 0
     * @param limit - limit of pages
     * @return list
     */
    @Override
    public List<DepartmentDTO> findAll(int page, int limit) {
        log.info("Found all departments");
        return departmentRepository.findAllDto(PageRequest.of(page, limit));
    }

    /**
     *The method calls repository's method to update department
     * @param department - department
     * @return updated department
     */
    @Override
    public DepartmentDTO update(Department department) {
        notNull(department, "department is null");
        final Department updated = departmentRepository.saveAndFlush(department);
        log.info("Updated department");
        return departmentRepository.findInId(updated.getId());
    }

    /**
     * The method calls repository's method to delete department
     * @param id - id
     */
    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("deleted department");
        departmentRepository.deleteById(id);
    }
}
