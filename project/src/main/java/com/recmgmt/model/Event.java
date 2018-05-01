package com.recmgmt.model;

import com.recmgmt.util.CommonDataUtil;
import com.recmgmt.util.Duration;

public class Event {
	private Integer eventID;
	private String eventName;
	private CommonDataUtil.EventType eventType;

	public Integer getEventLimit() {
		return eventLimit;
	}

	public void setEventLimit(Integer eventLimit) {
		this.eventLimit = eventLimit;
	}

	private Integer eventLimit;
	private Integer currentSize;
	private Duration duration;

	/*public Event() { }

	public Event(Integer _eventID, String _eventName, String _eventType, Integer _eventLimit, Duration _duration, Integer _currentSize) {
		this.eventID = _eventID;
		this.eventName = _eventName;
		this.eventType = CommonDataUtil.EventType.valueOf(_eventType);
		this.maxLimit = _eventLimit;
		this.duration = _duration;
		this.currentSize = _currentSize;
	}*/
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
	public void setEventType(String eventType) {
		this.eventType = CommonDataUtil.EventType.valueOf(eventType);
	}

	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public Integer getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(Integer currentSize) {
		this.currentSize = currentSize;
	}
}
