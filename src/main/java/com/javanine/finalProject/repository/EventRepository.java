package com.javanine.finalProject.repository;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.Event;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    @Query("select new com.javanine.finalProject.dto.EventDTO(e.id, e.eventName) from Event e where e.id = :id")
    EventDTO findInId(@Param("id") Long id);

    @Query("select new com.javanine.finalProject.dto.EventDTO(e.id, e.eventName) from Event e where e.eventName = :eName")
    EventDTO findByEventNameDto(@Param("eName") EmployeeEvent eventName);

    @Query("select new com.javanine.finalProject.dto.EventDTO(e.id, e.eventName) from Event e order by e.eventName")
    List<EventDTO> findAllDto(Pageable pageable);
}
