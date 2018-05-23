package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("select new com.javanine.finalProject.dto.PositionDTO(p.id, p.name) from Position p where p.name = :name")
    PositionDTO findByName(@Param("name") String name);

    @Query("select new com.javanine.finalProject.dto.PositionDTO(p.id, p.name) from Position p where p.id = :id")
    PositionDTO findInId(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.PositionDTO(p.id, p.name) from Position p")
    List<PositionDTO> findAllDto(Pageable pageable);
}
