package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;

public interface EventService extends ModelService<EventDTO, Event, Long> {

    EventDTO findByName(String eventName);
}
