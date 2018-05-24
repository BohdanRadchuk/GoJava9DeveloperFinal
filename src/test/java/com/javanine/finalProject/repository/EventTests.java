package com.javanine.finalProject.repository;

import com.javanine.finalProject.model.Event;
import com.javanine.finalProject.model.enums.EmployeeEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class EventTests {

    /**
     * The repository's layer object
     */

    @Autowired
    private EventRepository eventRepository;

    @Before
    public void before (){
        eventRepository.deleteAll();
    }

    /**
     * The test-method for same-named repository's default method that get one entity by ID.
     */
    @Test
    public void testSaveGetEvent() {
        Event actual = createNewEvent();
        eventRepository.save(actual);
        eventRepository.flush();

        Event obtained = eventRepository.findById(actual.getId()).get();

        Assert.assertEquals(actual, obtained);
    }

    /**
     * The test-method for findOne repository's default method that get one entity by ID=null.
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void sendNullId() {
        Long id = null;
        eventRepository.findById(id).get();
    }

    public Event createNewEvent() {
        Event event = new Event();
        event.setEventName(EmployeeEvent.WORKING_DAY);
        return event;
    }
}
