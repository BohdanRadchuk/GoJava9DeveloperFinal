package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import com.javanine.finalProject.repository.EventRepository;
import com.javanine.finalProject.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDTO findByName(String eventName) {
        hasText(eventName, "event name is empty");
        return eventRepository.findByEventNameDto(EmployeeEvent.valueOf(eventName));
    }

    @Override
    public EventDTO save(Event event) {
        notNull(event, "event is null");
        final Event saved = eventRepository.save(event);
        return eventRepository.findInId(saved.getId());
    }

    @Override
    public List<EventDTO> findAll(int page, int limit) {
        return eventRepository.findAllDto(PageRequest.of(page, limit));
    }

    @Override
    public EventDTO update(Event event) {
        notNull(event, "event is null");
        final Event updatedEvent = eventRepository.saveAndFlush(event);
        return eventRepository.findInId(updatedEvent.getId());
    }

    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        eventRepository.deleteById(id);
    }

    @Override
    public EventDTO findById(Long id) {
        notNull(id, "id is null");
        return eventRepository.findInId(id);
    }
}
