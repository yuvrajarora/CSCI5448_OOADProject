package com.recmgmt.daoImpl;

import com.recmgmt.model.Appointment;
import com.recmgmt.dao.IAppointmentDao;
import com.recmgmt.util.ConnectionFactory;
import com.recmgmt.util.Duration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements IAppointmentDao {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private List<Appointment> appointmentList;
    ConnectionFactory dbConnection;

    public AppointmentDaoImpl() {
        appointmentList = new ArrayList<Appointment>();
        dbConnection = ConnectionFactory.getConnectionFactoryInstance();
    }

    private Appointment extractUserFromResultSet(ResultSet rs) throws SQLException {
        Appointment apt = new Appointment();
        apt.setAppointeeID(resultSet.getInt("appointmentID"));
        apt.setTrainerID(resultSet.getInt("trainerID"));
        apt.setAppointeeID(resultSet.getInt("appointeeID"));
        //Need to convert to time
        //apt.setDuration(resultSet.getString("duration"));
        return apt;
    }

    public List<Appointment> getAppointmentList (Integer userId){
        try {
            preparedStatement = dbConnection.getConnection()
                    .prepareStatement("select appointmentID,trainerID,appointeeID, duration from Rec_Center_Mgmt_System.Court");
            resultSet = preparedStatement.executeQuery();

            //Clear the ArrayList
            appointmentList.clear();
            while(resultSet.next()) {
                Appointment apt = extractUserFromResultSet(resultSet);
                //Adding Appointment to List
                appointmentList.add(apt);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointmentList;

    }

    public String setAppointment (Integer _appId, Integer _trainerID, Duration _duration,
                                  Integer _appointeeId, String _appType)
    {
        return "Appointment Added";
    }
    public Appointment getAppointment (Integer appointmentID){
        Appointment testapp =  new Appointment();
        return testapp;
    }

    public String deleteAppointment (Integer appointmentID){
        try {
            preparedStatement = dbConnection.getConnection()
                    .prepareStatement("delete Rec_Center_Mgmt_System.User where appointmentID = ( ?)");
            preparedStatement.setInt(1, appointmentID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Success";
    }
}
