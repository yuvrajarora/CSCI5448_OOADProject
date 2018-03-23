package com.recmgmt.Model;

import com.recmgmt.enums.EventType;
import com.recmgmt.util.Duration;

public class Event {
	private Integer eventID;
	private String eventName;
	private EventType eventType;
	private Integer maxLimit;
	private Duration duration;
	
	public Event() { }
	
	public Event(Integer _eventID, String _eventName, String _eventType, Integer _eventLimit, Duration _duration) {
		this.eventID = _eventID;
		this.eventName = _eventName;
		this.eventType = EventType.valueOf(_eventType);
		this.maxLimit = _eventLimit;
		this.duration = _duration;
	}
	public Integer getEventID() {
		return eventID;
	}
	public void setEventID(Integer eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventType() {
		String type = eventType.name();
        return type;
	}
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public Integer getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(Integer maxLimit) {
		this.maxLimit = maxLimit;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
}
