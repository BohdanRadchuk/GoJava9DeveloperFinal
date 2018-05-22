package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.SettlementSheetDTO;
import com.javanine.finalProject.model.SettlementSheet;
import com.javanine.finalProject.repository.SettlementSheetRepository;
import com.javanine.finalProject.service.SettlementSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SettementSheetServiceImp implements SettlementSheetService {
    @Autowired
    private SettlementSheetRepository settlementSheetRepository;

    @Override
    public void save(SettlementSheet settlementSheet) {
        settlementSheetRepository.save(settlementSheet);
    }

    @Override
    public SettlementSheet findById(Long id) {
        return settlementSheetRepository.getOne(id);
    }

    @Override
    public List<SettlementSheet> findAll() {
        return settlementSheetRepository.findAll();
    }

    @Override
    public void update(SettlementSheet settlementSheet) {
        settlementSheetRepository.save(settlementSheet);
    }

    @Override
    public void deleteById(Long id) {
        settlementSheetRepository.deleteById(id);
    }

    @Override
    public SettlementSheetDTO findDto(Long id) {
        return settlementSheetRepository.findDto(id);
    }
}
