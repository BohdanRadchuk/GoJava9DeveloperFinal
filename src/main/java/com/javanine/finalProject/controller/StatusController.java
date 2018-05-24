package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusDTO> create(@RequestBody Status status) {
        final StatusDTO saved = statusService.save(status);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StatusDTO> update(@RequestBody Status status) {
        final StatusDTO statusDTO = statusService.update(status);
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<StatusDTO> findById(@RequestParam Long id) {
        final StatusDTO statusDTO = statusService.findById(id);
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<StatusDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<StatusDTO> statusDTO = statusService.findAll(page, limit);
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        statusService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
