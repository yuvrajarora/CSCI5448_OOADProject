package com.recmgmt.dao;

import com.recmgmt.Model.Event;
import com.recmgmt.util.Duration;

import java.util.List;

public interface IEventDao {
    // all are the abstract methods.
	public void addEvent (Event event);
	public void deleteEvent(Integer eventID);
	public void updateEvent(Event event);
	public List<String> getEventList();
	public void addUserToEvent(Integer userID, Integer eventID);
	public List<Event> getAllEventsOfType(String eventType);
	public List<Event> getAllEventsOfDate(Duration duration);
	public Event getEventDetails(Integer eventID);
	public List<String> fetchRegisteredUser(Integer eventID);
}