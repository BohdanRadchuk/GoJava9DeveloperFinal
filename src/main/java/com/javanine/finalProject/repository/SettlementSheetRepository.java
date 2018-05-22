package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.SettlementSheetDTO;
import com.javanine.finalProject.model.SettlementSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementSheetRepository extends JpaRepository<SettlementSheet, Long>{
    @Query("select new com.javanine.finalProject.dto.SettlementSheetDTO(s.id, e, s.year, s.month, s.workingHours, s.hospitalHours, s.holidayHours, s.salary) " +
            "from SettlementSheet s, Employee e where s.employee.id = e.id and s.id = :id")
    SettlementSheetDTO findDto(@Param("id") Long id);
}
