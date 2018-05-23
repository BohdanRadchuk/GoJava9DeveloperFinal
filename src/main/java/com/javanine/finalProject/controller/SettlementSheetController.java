package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.SettlementSheetDTO;
import com.javanine.finalProject.model.SettlementSheet;
import com.javanine.finalProject.service.SettlementSheetService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settlement-sheet")
public class SettlementSheetController {

    @Autowired
    private SettlementSheetService settlementSheetService;

    @PostMapping
    public ResponseEntity<SettlementSheetDTO> create(@RequestBody SettlementSheet settlementSheet) {
        val saved = settlementSheetService.save(settlementSheet);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<SettlementSheetDTO> update(@RequestBody SettlementSheet settlementSheet) {
        val updated = settlementSheetService.update(settlementSheet);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<SettlementSheetDTO> findById(@RequestParam Long id) {
        val settlementSheetDTO = settlementSheetService.findById(id);
        return new ResponseEntity<>(settlementSheetDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<SettlementSheetDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<SettlementSheetDTO> list = settlementSheetService.findAll(page, limit);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        settlementSheetService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
