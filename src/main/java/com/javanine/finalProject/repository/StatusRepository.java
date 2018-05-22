package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query("select new com.javanine.finalProject.dto.StatusDTO(s.id, s.statusName) from Status s where s.id = :id")
    StatusDTO findDto(@Param("id") Long id);
}
