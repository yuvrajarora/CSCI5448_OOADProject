package com.recmgmt.service;
import com.recmgmt.model.Event;
import com.recmgmt.daoImpl.EventDaoImpl;
import java.util.ArrayList;
import com.recmgmt.model.User;
import com.recmgmt.util.ApiResponse;
import com.recmgmt.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventDaoImpl eventDaoImpl;

    private ArrayList<Event> eventList;

    public Event getEventDetails(Integer eventID) {
        return eventDaoImpl.getEventDetails(eventID);
    }

    public ApiResponse addEvent (Event event) {
        return eventDaoImpl.addEvent(event);
    }

    public ApiResponse updateEvent(Integer eventId, Integer eventLimit) {
        return eventDaoImpl.updateEvent(eventId,eventLimit);
    }

    public ApiResponse deleteEvent(Integer eventID) {
        return eventDaoImpl.deleteEvent(eventID);
    }

    public ArrayList<Event> getEvents() {
        return (ArrayList<Event>) eventDaoImpl.getEventList();
    }

    public ApiResponse addUser(Integer eventID, Integer userId) {

        return eventDaoImpl.addUserToEvent(eventID,userId);
    }

    public ArrayList<Integer> getUserList(Integer eventID) {
        return eventDaoImpl.fetchRegisteredUser(eventID);
    }

    public ApiResponse checkAvailability(Integer eventID) {
        return eventDaoImpl.checkAvailability(eventID);
    }

    public ApiResponse checkErrors() {
        ApiResponse errMsg = new ApiResponse();
        return errMsg;
    }

    public boolean validateUser() {
        return true;
    }

    public String generateEventTicket(Event event, User user) {
        String ticket = "aws123";
        return ticket;
    }
}

