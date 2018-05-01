

package com.recmgmt.daoImpl;

import com.recmgmt.model.Event;
import com.recmgmt.util.ApiResponse;
//import com.recmgmt.util.ConnectionFactory;
import com.recmgmt.util.CommonDataUtil;
import com.recmgmt.util.DatabaseFactory;
import com.recmgmt.dao.IEventDao;
import com.recmgmt.util.Duration;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository //("eventDaoImpl")
public class EventDaoImpl implements IEventDao {

    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<Event> eventList;
    private ArrayList<Integer> userList;
    private Event event;
    private CommonDataUtil.DatabaseType databaseType = CommonDataUtil.DatabaseType.MySQL;
    private Connection connection;

    public EventDaoImpl() {
        eventList = new ArrayList<Event>();
        //ArrayList<Integer> userList = new ArrayList<Integer>();
        //event =  new Event();
        connection = DatabaseFactory.getConnection(databaseType);
    }

    @Override
    public ApiResponse addEvent (Event event) {
        ApiResponse result = new ApiResponse();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection
                    .prepareStatement("insert into  recmgmt.event (eventID,eventName,eventType,eventLimit,currentSize,startDate,startTime,endDate,endTime) " +
                            "values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, event.getEventID());
            preparedStatement.setString(2, event.getEventName());
            preparedStatement.setString(3, event.getEventType());
            preparedStatement.setInt(4, event.getEventLimit());
            preparedStatement.setInt(5, event.getCurrentSize());
            preparedStatement.setDate(6, event.getDuration().getStartDate());
            preparedStatement.setTime(7, event.getDuration().getStartTime());
            preparedStatement.setDate(8, event.getDuration().getEndDate());
            preparedStatement.setTime(9, event.getDuration().getEndTime());
            preparedStatement.executeUpdate();
            result.setSuccess(true);
            result.setMessage("Event creation Successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Event creation failed");
        }
        return result;
    }

    @Override
    public ApiResponse deleteEvent(Integer eventID) {
        ApiResponse result = new ApiResponse();
        try {
            preparedStatement = connection
                    .prepareStatement("delete from recmgmt.event where eventID = ( ?)");
            preparedStatement.setInt(1, eventID);
            preparedStatement.executeUpdate();
            result.setSuccess(true);
            result.setMessage("Event deletion Successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Event deletion failed");
        }
        return result;
    }

    @Override
    public ApiResponse updateEvent(Integer eventId, Integer eventSize) {
        ApiResponse result = new ApiResponse();

        try {
            preparedStatement = connection
                    .prepareStatement("update recmgmt.Event set eventLimit=? where eventID=?");
            preparedStatement.setInt(1, eventSize);
            preparedStatement.setInt(2, eventId);
            preparedStatement.executeUpdate();
            result.setSuccess(true);
            result.setMessage("Event Updation Successful");
        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Event Updation failed");
        }
        return result;
    }

    private Event extractEventFromResultSet(ResultSet rs) throws SQLException {
        Event event = new Event();
        event.setEventID(resultSet.getInt("eventID"));
        event.setEventName(resultSet.getString("eventName"));
        event.setEventType(resultSet.getString("eventType"));
        event.setEventLimit(resultSet.getInt("eventLimit"));
        event.setCurrentSize(resultSet.getInt("currentSize"));
        Duration duration = new Duration();
        duration.setStartDate((resultSet.getDate("startDate")));
        duration.setStartTime(resultSet.getTime("startTime"));
        duration.setEndDate(resultSet.getDate("endDate"));
        duration.setEndTime(resultSet.getTime("endTime"));
        event.setDuration(duration);
        return event;
    }

    @Override
    public List<Event> getEventList(){
        try {
            preparedStatement = connection
                    .prepareStatement("select * from recmgmt.Event ");
            resultSet = preparedStatement.executeQuery();

            //Clear the ArrayList
            eventList.clear();
            int i = 0;
            while(resultSet.next()) {
                Event event = extractEventFromResultSet(resultSet);
                //Adding Event to List
                eventList.add(event);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public void updateEventById(Integer eventId, Integer currentSize){
        try {
            connection
                    .prepareStatement("update recmgmt.Event set currentSize=? where eventID=?");
            preparedStatement.setInt(1, currentSize);
            preparedStatement.setInt(2, eventId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ApiResponse checkAvailability(Integer eventId){
        ApiResponse result = new ApiResponse();
        try {
            preparedStatement = connection
                    .prepareStatement("select eventLimit, currentSize, eventType from recmgmt.Event where eventID = ?");
            preparedStatement.setInt(1, eventId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer maxLimit = resultSet.getInt("eventLimit");
                Integer currentSize = resultSet.getInt("currentSize");
                String eventType = resultSet.getString("eventType");
                if  (currentSize > maxLimit)
                {
                    result.setSuccess(false);
                    result.setMessage("No Seats Availability");
                }

                else {
                    Integer vacancy = maxLimit - currentSize;
                    result.setSuccess(true);
                    result.setMessage(vacancy + "\tseats out of total\t" + maxLimit + "\tseat available.");
                }
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Check vacancy availibility status Failed");
        }
        return result;
    }

    @Override
    public ApiResponse addUserToEvent(Integer eventID, Integer userID) {
        ApiResponse result = new ApiResponse();
        String eventType;
        Integer maxLimit;
        String regId;
        Integer currentSize;
        try {
            preparedStatement = connection
                    .prepareStatement("select eventLimit, currentSize, eventType from recmgmt.Event where eventID = ?");
            preparedStatement.setInt(1, eventID);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next() ) {
                System.out.println("no data");
            }

            maxLimit = resultSet.getInt("eventLimit");
            currentSize = resultSet.getInt("currentSize");
            eventType = resultSet.getString("eventType");
            if  (currentSize >= maxLimit)
            {
                result.setSuccess(false);
                result.setMessage("Registration Failed");
            }

            else {
                preparedStatement = null;
                preparedStatement = connection
                        .prepareStatement("insert into  recmgmt.EventRegistration (regID,eventID,userID,eventType) values ( ?, ?, ?, ?)");
                regId = UUID.randomUUID().toString();

                preparedStatement.setString(1, regId);
                preparedStatement.setInt(2, eventID);
                preparedStatement.setInt(3, userID);
                preparedStatement.setString(4, eventType);

                preparedStatement.executeUpdate();
                currentSize = currentSize + 1;

                updateEventById(eventID,currentSize);
                result.setSuccess(true);
                result.setMessage("Registration Successful");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Registration Failed");
        }
        return result;
    }

    public List<Event> getAllEventsOfType(String eventType) {
        try {
            preparedStatement = connection
                    .prepareStatement("select * from recmgmt.Event where eventType=?");
            preparedStatement.setString(1, eventType);
            resultSet = preparedStatement.executeQuery();

            //Clear the ArrayList
            eventList.clear();
            while(resultSet.next()) {
                Event event = extractEventFromResultSet(resultSet);
                //Adding User to List
                eventList.add(event);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public List<Event> getAllEventsOfDate() {
        try {

            preparedStatement = connection
                    .prepareStatement("select * from recmgmt.Event order by startDate, startTime desc");
            resultSet = preparedStatement.executeQuery();

            //Clear the ArrayList
            eventList.clear();
            while(resultSet.next()) {
                Event event = extractEventFromResultSet(resultSet);
                //Adding User to List
                eventList.add(event);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventList;
    }

    public Event getEventDetails(Integer eventID){
        try {
            preparedStatement = connection
                    .prepareStatement("select * from recmgmt.Event where eventID=?");
            preparedStatement.setInt(1, eventID);
            resultSet = preparedStatement.executeQuery();

            event = extractEventFromResultSet(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public ArrayList<Integer> fetchRegisteredUser(Integer eventID) {
        try {
            preparedStatement = connection
                    .prepareStatement("select userID from recmgmt.EventRegistration where eventID = ?");
            preparedStatement.setInt(1, eventID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer userId = resultSet.getInt("userID");
                userList.add(userId);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}

