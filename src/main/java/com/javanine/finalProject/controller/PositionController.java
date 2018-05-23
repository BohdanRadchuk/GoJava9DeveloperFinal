package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping
    public ResponseEntity<PositionDTO> create(@RequestBody Position position) {
        final PositionDTO saved = positionService.save(position);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PositionDTO> update(@RequestBody Position position) {
        final PositionDTO updated = positionService.update(position);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<PositionDTO> findById(@RequestParam Long id) {
        final PositionDTO positionDTO = positionService.findById(id);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<PositionDTO> findByName(@RequestParam String name) {
        final PositionDTO positionDTO = positionService.findByName(name);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PositionDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<PositionDTO> positionDTO = positionService.findAll(page, limit);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        positionService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
