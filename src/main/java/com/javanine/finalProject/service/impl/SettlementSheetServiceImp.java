package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.SettlementSheetDTO;
import com.javanine.finalProject.model.SettlementSheet;
import com.javanine.finalProject.repository.SettlementSheetRepository;
import com.javanine.finalProject.service.SettlementSheetService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.util.Assert.notNull;
@Slf4j
@Service
public class SettlementSheetServiceImp implements SettlementSheetService {

    @Autowired
    private SettlementSheetRepository settlementSheetRepository;

    @Override
    public SettlementSheetDTO save(SettlementSheet settlementSheet) {
        notNull(settlementSheet, "settlement sheet is null");
        val saved = settlementSheetRepository.save(settlementSheet);
        log.info("SettlementSheet created");
        return settlementSheetRepository.findInIdDto(saved.getId());
    }

    @Override
    public SettlementSheetDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("SettlementSheet found");
        return settlementSheetRepository.findInIdDto(id);
    }

    @Override
    public List<SettlementSheetDTO> findAll(int page, int limit) {
        log.info(" Found all SettlementSheets");
        return settlementSheetRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public SettlementSheetDTO update(SettlementSheet settlementSheet) {
        notNull(settlementSheet, "settlement sheet is null");
        val updated = settlementSheetRepository.saveAndFlush(settlementSheet);
        log.info("SettlementSheet updated");
        return settlementSheetRepository.findInIdDto(updated.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("SettlementSheet deleted");
        settlementSheetRepository.deleteById(id);
    }
}
