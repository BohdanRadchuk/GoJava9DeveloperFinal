package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.DepartmentDTO;
import com.javanine.finalProject.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Department findByName(String name);

    @Query("select new com.javanine.finalProject.dto.DepartmentDTO(d.id, d.name) from Department d where d.id = :id")
    DepartmentDTO findDto(@Param("id") Long id);
}
