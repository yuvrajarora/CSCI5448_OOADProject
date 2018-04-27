/*
package com.recmgmt.daoImpl;

import com.recmgmt.model.Event;
import com.recmgmt.util.ConnectionFactory;
import com.recmgmt.dao.IEventDao;
import com.recmgmt.util.Duration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EventDaoImpl implements IEventDao {
	
	private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<Event> eventList;
    ConnectionFactory dbConnection;
    
    public EventDaoImpl() {
    	eventList = new ArrayList<Event>();
    	dbConnection = ConnectionFactory.getConnectionFactoryInstance();
    }
	
	public void addEvent (Event event) {
		Integer eventID = event.getEventID();
		String eventName = event.getEventName();
		String eventType = event.getEventType();
		Integer eventLimit = event.getMaxLimit();
		Duration duration = event.getDuration();
		//Date sDur = duration.getStartDuration();
		//Date eDur = duration.getEndDuration();
		String startTime = duration.getStartTime(sDur);
		String endTime = duration.getEndTime(eDur);
		String startDate = duration.getStartDate(sDur);
		String endDate = duration.getEndDate(eDur);
		
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("insert into  Rec_Center_Mgmt_System.Event values ( ?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setInt(1, eventID);
	        preparedStatement.setString(2, eventName);
	        preparedStatement.setString(3, eventType);
	        preparedStatement.setInt(4, eventLimit);
	        preparedStatement.setDate(5, java.sql.Date.valueOf(startDate));
	        preparedStatement.setTimestamp(6, java.sql.Timestamp.valueOf(startTime));
	        preparedStatement.setDate(7, java.sql.Date.valueOf(endDate));
	        preparedStatement.setTimestamp(8, java.sql.Timestamp.valueOf(endTime));
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEvent(Integer eventID) {
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("delete Rec_Center_Mgmt_System.User where eventID = ( ?)");
			preparedStatement.setInt(1, eventID);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEvent(Event event) {
		Integer eventID = event.getEventID();
	    String eventName = event.getEventName(); 
	    String eventType = event.getEventType();
	    Integer maxEventLimit = event.getMaxLimit();
	    Duration duration = event.getDuration();
		Date sDur = duration.getStartDuration();
		Date eDur = duration.getEndDuration();
		String startTime = duration.getStartTime(sDur);
		String endTime = duration.getEndTime(eDur);
		String startDate = duration.getStartDate(sDur);
		String endDate = duration.getEndDate(eDur);
	    
		try {
			preparedStatement = dbConnection.getConnection()
					.prepareStatement("update Rec_Center_Mgmt_System.Event set eventID=?, eventName=?, eventType=?, eventLimit=?, startDate=?, startTime=?, endDate=?, endTime=?");
			preparedStatement.setInt(1, eventID);
	        preparedStatement.setString(2, eventName);
	        preparedStatement.setString(3, eventType);
	        preparedStatement.setInt(4, maxEventLimit);
	        preparedStatement.setString(5, startDate);
	        preparedStatement.setString(6, startTime);
	        preparedStatement.setString(7, endDate);
	        preparedStatement.setString(7, endTime);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	}
	}
	
	public List<String> getEventList(){ return null;}
	public void addUserToEvent(Integer userID, Integer eventID) { }
	public List<Event> getAllEventsOfType(String eventType) {return null; }
	public List<Event> getAllEventsOfDate(Duration duration) { return null;}
	public Event getEventDetails(Integer eventID) {return null; }
	public List<String> fetchRegisteredUser(Integer eventID) {return null; }
}
*/
