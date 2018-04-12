package com.recmgmt.service;
import com.recmgmt.model.Event;
import com.recmgmt.util.*;
import com.recmgmt.daoImpl.EventDaoImpl;
import java.util.ArrayList;
import com.recmgmt.model.User;

public class EventService {
	private EventDaoImpl eventDaoImpl;
	private ArrayList<Event> eventList;
	
	public EventService() {
		eventDaoImpl = new EventDaoImpl();
	}
	public void setEventDaoImpl(EventDaoImpl eventDaoImpl) {
		this.eventDaoImpl = eventDaoImpl;
	}

	public Event getEventDetails(Integer eventID) { 
		//Creating dummy Event
		Event event = new Event();
		event = null;
		return event;
	}
	
	public ErrorMessage addEvent (Event event) { 
		ErrorMessage errMsg = new ErrorMessage();
		return errMsg;
	}
	
	public ErrorMessage updateEvent(Integer eventID) {
		ErrorMessage errMsg = new ErrorMessage();
		return errMsg;
	}
	
	public ErrorMessage deleteEvent(Integer eventID) {
		ErrorMessage errMsg = new ErrorMessage();
		return errMsg;
	}
	
	public EventDaoImpl getEventDaoImpl() {
		return eventDaoImpl;
	}
	
	public ArrayList<Event> getEvents() {
		return eventList;
	}
	
	public ErrorMessage addUser(User user, Integer eventID) {
		ErrorMessage errMsg = new ErrorMessage();
		return errMsg;
	}
	
	public ArrayList<Event> getUserList(Integer eventID) {
		return eventList;
	}
	
	public boolean checkAvailability(Integer eventID) {
		return true;
	}
	
	public ErrorMessage checkErrors() {
		ErrorMessage errMsg = new ErrorMessage();
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
