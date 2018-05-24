package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.WorkingDayDTO;
import com.javanine.finalProject.model.WorkingDay;
import com.javanine.finalProject.service.WorkingDayService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/working-day")
@Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR})
public class WorkingDayController {

    @Autowired
    private WorkingDayService workingDayService;

    /**
     * Creating workingDay
     * @param workingDay - workingDay
     * @return saved workingDay
     */
    @PostMapping
    public ResponseEntity<WorkingDayDTO> create(@RequestBody WorkingDay workingDay) {
        final WorkingDayDTO saved = workingDayService.save(workingDay);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    /**
     * Updating workingDay
     * @param workingDay - workingDay
     * @return updated workingDay
     */
    @PutMapping
    public ResponseEntity<WorkingDayDTO> update(@RequestBody WorkingDay workingDay) {
        final WorkingDayDTO updated = workingDayService.update(workingDay);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    /**
     * Getting list of workingDays
     * @param page - page of list,starting from 0
     * @param limit - limit of pages
     * @return workingDay {@link WorkingDayDTO}
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<WorkingDayDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<WorkingDayDTO> workingDayDTO = workingDayService.findAll(page, limit);
        return new ResponseEntity<>(workingDayDTO, HttpStatus.OK);
    }

    /**
     * Getting workingDay by id
     * @param id - id
     * @return workingDay {@link WorkingDayDTO}
     */
    @GetMapping("/findOne")
    public ResponseEntity<WorkingDayDTO> findById(@RequestParam Long id) {
        final WorkingDayDTO workingDayDTO = workingDayService.findById(id);
        return new ResponseEntity<>(workingDayDTO, HttpStatus.OK);
    }

    /**
     * Getting list of workingDays by employee
     * @param id - id
     * @param startDate - startDay
     * @param endDate - endDay
     * @return workingDay {@link WorkingDayDTO}
     */
    @GetMapping("/findByEmployee")
    @Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR, RoleUtil.ROLE_EMPLOYEE})
    public ResponseEntity<List<WorkingDayDTO>> findByEmployee(@RequestParam Long id, Date startDate, Date endDate) {
        final List<WorkingDayDTO> workingDayDTO = workingDayService.findByEmployee(id, startDate, endDate);
        return new ResponseEntity<>(workingDayDTO, HttpStatus.OK);
    }

    /**
     * Delete workingDay by id
     * @param id - id
     * @return empty value
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        workingDayService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
