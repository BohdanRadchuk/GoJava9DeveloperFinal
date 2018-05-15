package com.javanine.finalProject.service;

import com.javanine.finalProject.model.Event;

public interface EventService extends ModelService<Event, Long>{
    Event findByEventName(String eventName);
}
