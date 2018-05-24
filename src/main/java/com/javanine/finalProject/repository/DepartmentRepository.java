package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select new com.javanine.finalProject.dto.DepartmentDTO(d.id, d.name) from Department d where d.id = :id")
    DepartmentDTO findInId(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.DepartmentDTO(d.id, d.name) from Department d where d.name = :dName")
    DepartmentDTO findByNameDto(@Param("dName") String name);

    @Query("select new com.javanine.finalProject.dto.DepartmentDTO(d.id, d.name) from Department d order by d.name")
    List<DepartmentDTO> findAllDto(Pageable pageable);
}
