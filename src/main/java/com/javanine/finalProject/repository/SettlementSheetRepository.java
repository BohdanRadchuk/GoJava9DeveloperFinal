package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.SettlementSheetDTO;
import com.javanine.finalProject.model.SettlementSheet;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettlementSheetRepository extends JpaRepository<SettlementSheet, Long> {

    @Query("select new com.javanine.finalProject.dto.SettlementSheetDTO(s.id, e, s.year, s.month, s.workingHours, s.hospitalHours, s.holidayHours, s.salary) " +
            "from SettlementSheet s, Employee e where s.employeeId = e.id and s.id = :id")
    SettlementSheetDTO findInIdDto(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.SettlementSheetDTO(s.id, e, s.year, s.month, s.workingHours, s.hospitalHours, s.holidayHours, s.salary) " +
            "from SettlementSheet s, Employee e where s.employeeId = e.id")
    List<SettlementSheetDTO> findAllDto(Pageable pageable);
}
