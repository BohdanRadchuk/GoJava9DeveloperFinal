package com.javanine.finalProject.controller;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;
import com.javanine.finalProject.service.EventService;
import com.javanine.finalProject.util.RoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/event")
@Secured({RoleUtil.ROLE_ADMIN})
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<EventDTO> create(@RequestBody Event event) {
        final EventDTO saved = eventService.save(event);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EventDTO> update(@RequestBody Event event) {
        final EventDTO updated = eventService.update(event);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/findOne")
    public ResponseEntity<EventDTO> findById(@RequestParam Long id) {
        final EventDTO eventDTO = eventService.findById(id);
        return new ResponseEntity<>(eventDTO, HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<EventDTO> findByName(@RequestParam String name) {
        final EventDTO eventDTO = eventService.findByName(name);
        return new ResponseEntity<>(eventDTO, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    @Secured({RoleUtil.ROLE_ADMIN, RoleUtil.ROLE_MODERATOR})
    public ResponseEntity<List<EventDTO>> findAll(@RequestParam int page, @RequestParam int limit) {
        final List<EventDTO> eventDTO = eventService.findAll(page, limit);
        return new ResponseEntity<>(eventDTO, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) {
        eventService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
