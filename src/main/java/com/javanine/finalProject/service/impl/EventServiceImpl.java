package com.javanine.finalProject.service.impl;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import com.javanine.finalProject.repository.EventRepository;
import com.javanine.finalProject.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

/**
 * Service layer {@link EventService}
 */

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    /**
     * The method calls repository's method to get event by name
     * @param eventName - name
     * @return eventName
     */
    @Override
    public EventDTO findByName(String eventName) {
        hasText(eventName, "event name is empty");
        log.info("Found event by name");
        return eventRepository.findByEventNameDto(EmployeeEvent.valueOf(eventName));
    }

    /**
     * The method calls repository's method to save event
     * @param event - event
     * @return saved event
     */
    @Override
    public EventDTO save(Event event) {
        notNull(event, "event is null");
        final Event saved = eventRepository.save(event);
        log.info("Event saved");
        return eventRepository.findInId(saved.getId());
    }

    /**
     * The method calls repository's method to get list of events
     * @param page - starts from 0
     * @param limit - limit of pages
     * @return list
     */
    @Override
    public List<EventDTO> findAll(int page, int limit) {
        log.info("All events found");
        return eventRepository.findAllDto(PageRequest.of(page, limit));
    }

    /**
     * The method calls repository's method to update employee
     * @param event - event
     * @return updated event
     */
    @Override
    public EventDTO update(Event event) {
        notNull(event, "event is null");
        final Event updatedEvent = eventRepository.saveAndFlush(event);
        log.info("Event updated");
        return eventRepository.findInId(updatedEvent.getId());
    }

    /**
     * The method calls repository's method to delete event
     * @param id -id
     */
    @Override
    public void deleteById(Long id) {
        notNull(id, "id is null");
        log.info("Deleted event");
        eventRepository.deleteById(id);
    }

    /**
     * The method calls repository's method to get event by id
     * @param id - id
     * @return id
     */
    @Override
    public EventDTO findById(Long id) {
        notNull(id, "id is null");
        log.info("Found one event");
        return eventRepository.findInId(id);
    }
}
