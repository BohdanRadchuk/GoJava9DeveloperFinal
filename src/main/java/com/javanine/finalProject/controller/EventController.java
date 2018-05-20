package com.javanine.finalProject.controller;

import com.javanine.finalProject.model.Event;
import com.javanine.finalProject.model.Status;
import com.javanine.finalProject.service.impl.EventServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@Api(value = "events", description = "Operations with events")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @ApiOperation(value = "View a list of available products", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/list", produces = "application/json")
    public List<Event> list(Model model) {
        List<Event> eventList = eventService.findAll();
        System.out.println(eventList);
        return eventList;
    }


    @ApiOperation(value = "Search a product with an ID", response = Status.class)
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
    public Event showProduct(@PathVariable Long id, Model model) {
        System.out.println(id);
        Event event = eventService.findById(id);
        System.out.println(event);
        return event;
    }
}
