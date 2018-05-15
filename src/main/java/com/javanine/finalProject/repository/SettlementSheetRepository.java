package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.SettlementSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementSheetRepository extends JpaRepository<SettlementSheet, Long>{
}
