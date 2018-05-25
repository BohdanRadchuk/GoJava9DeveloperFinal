package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;

/**
 * Interface for service's layer of Event.Extends CRUD methods from {@link com.javanine.finalProject.service.ModelService}
 */
public interface EventService extends ModelService<EventDTO, Event, Long> {
    /**
     * Get event by name
     * @param eventName - name
     * @return event
     */
    EventDTO findByName(String eventName);
}
