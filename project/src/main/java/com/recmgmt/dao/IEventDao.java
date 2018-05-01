package com.recmgmt.dao;

import com.recmgmt.model.Event;
import com.recmgmt.util.ApiResponse;
import com.recmgmt.util.Duration;

import java.util.ArrayList;
import java.util.List;

public interface IEventDao {
	// all are the abstract methods.
	public ApiResponse addEvent (Event event);
	public ApiResponse deleteEvent(Integer eventID);
	public ApiResponse updateEvent(Integer eventId, Integer eventSize);
	public List<Event> getEventList();
	public ApiResponse addUserToEvent(Integer userID, Integer eventID);
	public List<Event> getAllEventsOfType(String eventType);
	public List<Event> getAllEventsOfDate();
	public Event getEventDetails(Integer eventID);
	public ArrayList<Integer> fetchRegisteredUser(Integer eventID);
}