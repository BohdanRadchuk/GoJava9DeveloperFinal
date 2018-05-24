package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.StatusDTO;
import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.service.StatusService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/status")
@Secured({RoleUtil.ROLE_ADMIN})
public class StatusController {

    @Autowired
    private StatusService statusService;

    /**
     * Creating status
     * @param status - status
     * @return saved status
     */
    @PostMapping
    public ResponseEntity<StatusDTO> create(@RequestBody Status status) {
        final StatusDTO saved = statusService.save(status);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    /**
     * Updating status
     * @param status - status
     * @return status {@link StatusDTO}
     */
    @PutMapping
    public ResponseEntity<StatusDTO> update(@RequestBody Status status) {
        final StatusDTO statusDTO = statusService.update(status);
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    /**
     * Getting status by id
     * @param id - id
     * @return status {@link StatusDTO}
     */
    @GetMapping("/findOne")
    public ResponseEntity<StatusDTO> findById(@RequestParam Long id) {
        final StatusDTO statusDTO = statusService.findById(id);
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    /**
     *Getting all statuses
     * @param page - page of list,starting from 0
     * @param limit - limit of pages
     * @return list of status {@link StatusDTO}
     */
    @GetMapping("/findAll")
    @Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR})
    public ResponseEntity<List<StatusDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<StatusDTO> statusDTO = statusService.findAll(page, limit);
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    /**
     * Delete status
     * @param id - id
     * @return empty value
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        statusService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
