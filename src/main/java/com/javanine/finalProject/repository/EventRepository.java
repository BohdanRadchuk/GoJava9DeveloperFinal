package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    Event findByEventName(String eventName);

    @Query("select new com.javanine.finalProject.dto.EventDTO(e.id, e.eventName) from Event e where e.id = :id")
    EventDTO findDto(@Param("id") Long id);
}
