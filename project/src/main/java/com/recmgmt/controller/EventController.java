package com.recmgmt.controller;
import com.recmgmt.model.Event;
import com.recmgmt.service.EventService;
import com.recmgmt.util.ApiResponse;
import com.recmgmt.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.util.*;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    //EventService getter function
    public EventService getEventService() {
        return eventService;
    }

    //EventService setter function
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }
    public void fetchEvents() { }
    public void fetchEventDetails() { }
    public void registerUser(Integer userID, Integer eventID) { }
    public void fetchAvailability(Integer eventID) { }

    //Function to create and add new event
    @RequestMapping(path="/add_event",method = RequestMethod.POST,headers="Content-Type=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse addNewEvent(@RequestBody Event event) throws ParseException {
        return eventService.addEvent(event);
    }

    //Function to delete an existing event
    @RequestMapping(path="/delete_event/{eventID}",method = RequestMethod.POST,headers="Content-Type=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse deleteEvent(@PathVariable Integer eventID) throws ParseException {
        return eventService.deleteEvent(eventID);
    }

    //Function to update event limit and duration for an event
    @RequestMapping(path="/update_event",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse updateEvent(@RequestParam("eventID") Integer eventID,
                                   @RequestParam("eventLimit") Integer eventLimit) throws ParseException {
        return eventService.updateEvent(eventID, eventLimit);
    }

    //Function to fetch the events list
    @RequestMapping(path="/fetch_events",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public ArrayList<Event> getEvents() throws ParseException {
        return (ArrayList<Event>) eventService.getEvents();
    }

    //Function to add user to events
    @RequestMapping(path="/event_reg",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse register_event(@RequestParam("eventID") Integer eventID,
                                      @RequestParam("userID") Integer userID) throws ParseException {
        return  eventService.addUser(eventID,userID);
    }
}

