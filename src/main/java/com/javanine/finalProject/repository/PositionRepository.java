package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{
    Position findByName(String name);

    @Query("select new com.javanine.finalProject.dto.PositionDTO(p.id, p.name, d.name, e) from Position p, Department d, Employee e " +
            "where p.department.id = p.id and p.employee.id = e.id and p.id = :id")
    PositionDTO findDto(@Param("id") Long id);
}
