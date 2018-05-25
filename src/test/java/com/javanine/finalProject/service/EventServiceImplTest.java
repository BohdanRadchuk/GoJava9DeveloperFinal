package com.javanine.finalProject.service;

import com.javanine.finalProject.dto.EventDTO;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import com.javanine.finalProject.repository.EventRepository;
import com.javanine.finalProject.service.impl.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class EventServiceImplTest {

    @TestConfiguration
    static class EventServiceImplTestContextConfiguration {

        @Bean
        public EventService eventService() {
            return new EventServiceImpl();
        }
    }

    @Autowired
    private EventService eventService;

    @MockBean
    private EventRepository eventRepository;

    @Before
    public void setUp() {
        EventDTO event = new EventDTO();
        event.setEventName(EmployeeEvent.WORKING_DAY);

        Mockito.when(eventRepository.findByEventNameDto(event.getEventName()))
                .thenReturn(event);
    }

    @Test
    public void whenValidEventName_thenEventShouldBeFound() {
        EventDTO found = eventService.findByName(EmployeeEvent.WORKING_DAY.toString());

        assertThat(found.getEventName().toString())
                .isEqualTo(EmployeeEvent.WORKING_DAY.toString());
    }
}
