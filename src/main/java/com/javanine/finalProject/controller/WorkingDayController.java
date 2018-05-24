package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.WorkingDay;
import com.javanine.finalProject.service.WorkingDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/working-day")
public class WorkingDayController {

    @Autowired
    private WorkingDayService workingDayService;

    @PostMapping
    public ResponseEntity<WorkingDayDTO> create(@RequestBody WorkingDay workingDay) {
        final WorkingDayDTO saved = workingDayService.save(workingDay);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WorkingDayDTO> update(@RequestBody WorkingDay workingDay) {
        final WorkingDayDTO updated = workingDayService.update(workingDay);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<WorkingDayDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<WorkingDayDTO> workingDayDTO = workingDayService.findAll(page, limit);
        return new ResponseEntity<>(workingDayDTO, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<WorkingDayDTO> findById(@RequestParam Long id) {
        final WorkingDayDTO workingDayDTO = workingDayService.findById(id);
        return new ResponseEntity<>(workingDayDTO, HttpStatus.OK);
    }

    @GetMapping("/findByEmployee")
    public ResponseEntity<List<WorkingDayDTO>> findByEmployee(@RequestParam Long id, Date startDate, Date endDate) {
        final List<WorkingDayDTO> dayDTO = workingDayService.findByEmployee(id, startDate, endDate);
        return new ResponseEntity<>(dayDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        workingDayService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
