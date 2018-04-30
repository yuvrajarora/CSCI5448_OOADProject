package com.recmgmt.daoImpl;

import com.recmgmt.dao.ICourtReservationDao;
import com.recmgmt.model.Court;
import com.recmgmt.model.Reservation;
import com.recmgmt.util.ConnectionFactory;
import com.recmgmt.util.ApiResponse;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dixit Patel
 */

@Repository
public class CourtReservationDaoImpl implements ICourtReservationDao {


    private Connection connection;
    private List<Court> courtList;
    private ResultSet resultSet = null;

    public CourtReservationDaoImpl() {
        connection = ConnectionFactory.getConnectionFactoryInstance().getConnection();
    }

    @Override
    public ApiResponse reserveCourt(Reservation reservation) {

        PreparedStatement preparedStatement = null;
        ApiResponse result = new ApiResponse();
        try {
            preparedStatement = connection
                    .prepareStatement("insert into  recmgmt.reservation (court_id,user_id,start_time,end_time,start_date,end_date) values ( ?, ?, ?, ?, ?,?)");
            preparedStatement.setInt(1, reservation.getCourt_id());
            preparedStatement.setInt(2, reservation.getUser_id());
            preparedStatement.setTime(3, reservation.getDuration().getStartTime());
            preparedStatement.setTime(4, reservation.getDuration().getEndTime());
            preparedStatement.setDate(5, reservation.getDuration().getStartDate());
            preparedStatement.setDate(6, reservation.getDuration().getEndDate());
            preparedStatement.executeUpdate();
            result.setSuccess(true);
            result.setMessage("Reservation Successful");

        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Reservation Failed");

        }

        return result;
    }

    @Override
    public ApiResponse deleteCourt(Reservation reservation) {
        PreparedStatement preparedStatement = null;
        ApiResponse result = new ApiResponse();
        try {
            preparedStatement = connection
                    .prepareStatement("delete from recmgmt.reservation where (court_id =? AND user_id=? AND start_time=? AND end_time=? AND start_date=? AND end_date=?)");
            preparedStatement.setInt(1, reservation.getCourt_id());
            preparedStatement.setInt(2, reservation.getUser_id());
            preparedStatement.setTime(3, reservation.getDuration().getStartTime());
            preparedStatement.setTime(4, reservation.getDuration().getEndTime());
            preparedStatement.setDate(5, reservation.getDuration().getStartDate());
            preparedStatement.setDate(6, reservation.getDuration().getEndDate());
            preparedStatement.executeUpdate();
            result.setSuccess(true);
            result.setMessage("Reservation deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Reservation deletion Failed");

        }

        return result;
    }

    private Court extractUserFromResultSet(ResultSet rs) throws SQLException {
        Court crt = new Court();
        crt.setCourtID(resultSet.getInt("court_id"));
        crt.setName(resultSet.getString("court_name"));
        crt.setResType(resultSet.getString("court_type"));
        return crt;
    }

    @Override
    public String fetchCourts() {
        StringBuilder stringBuilder = new StringBuilder();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement("select * from recmgmt.court");
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) ;
                    String columnValue = resultSet.getString(i);
                    stringBuilder.append(columnValue + ": " + rsmd.getColumnName(i) + " , ");
                }
                stringBuilder.append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No Court found!");

        }
        return stringBuilder.toString();

    }


    @Override
    public String getUserReservationList(int userID) {
        StringBuilder stringBuilder = new StringBuilder();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement("select * from recmgmt.reservation where user_id=?");
            preparedStatement.setInt(1, userID);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) ;
                    String columnValue = resultSet.getString(i);
                    stringBuilder.append(columnValue + ": " + rsmd.getColumnName(i) + " , ");
                }
                stringBuilder.append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No Record found!");

        }
        return stringBuilder.toString();
    }
}

