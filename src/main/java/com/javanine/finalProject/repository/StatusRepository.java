package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select new com.javanine.finalProject.dto.StatusDTO(s.id, s.statusName) from Status s where s.id = :id")
    StatusDTO findInId(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.StatusDTO(s.id, s.statusName) from Status s")
    List<StatusDTO> findAllDto(Pageable pageable);
}
