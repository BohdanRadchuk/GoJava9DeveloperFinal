package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.PositionDTO;
import com.javanine.finalProject.model.Position;
import com.javanine.finalProject.service.PositionService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/position")
@Secured({RoleUtil.ROLE_ADMIN})
public class PositionController {

    @Autowired
    private PositionService positionService;

    /**
     * Creating a position
     * @param position - position
     * @return saved position
     */
    @PostMapping
    public ResponseEntity<PositionDTO> create(@RequestBody Position position) {
        final PositionDTO saved = positionService.save(position);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    /**
     * Updating position
     * @param position - position
     * @return updated position
     */
    @PutMapping
    public ResponseEntity<PositionDTO> update(@RequestBody Position position) {
        final PositionDTO updated = positionService.update(position);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    /**
     * Getting position by id
     * @param id - id
     * @return position {@link PositionDTO}
     */
    @GetMapping("/findOne")
    public ResponseEntity<PositionDTO> findById(@RequestParam Long id) {
        final PositionDTO positionDTO = positionService.findById(id);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    /**
     * Getting position by name
     * @param name - name
     * @return position {@link PositionDTO}
     */
    @GetMapping("/findByName")
    public ResponseEntity<PositionDTO> findByName(@RequestParam String name) {
        final PositionDTO positionDTO = positionService.findByName(name);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    /**
     * Getting list of positions
     * @param page - page of list,starting from 0
     * @param limit - limit of pages
     * @return list of positions {@link PositionDTO}
     */
    @GetMapping("/findAll")
    @Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR})
    public ResponseEntity<List<PositionDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<PositionDTO> positionDTO = positionService.findAll(page, limit);
        return new ResponseEntity<>(positionDTO, HttpStatus.OK);
    }

    /**
     * Delete position by id
     * @param id - id
     * @return empty value
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        positionService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
