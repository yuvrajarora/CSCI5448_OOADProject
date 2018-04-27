package com.recmgmt.daoImpl;

import com.recmgmt.dao.ICourtReservationDao;
import com.recmgmt.model.Court;
import com.recmgmt.model.Reservation;
import com.recmgmt.util.ConnectionFactory;
import com.recmgmt.util.ApiResponse;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Dixit Patel
 */

@Repository
public class CourtReservationDaoImpl implements ICourtReservationDao {


    private Connection connection;

    public CourtReservationDaoImpl() {
        connection = ConnectionFactory.getConnectionFactoryInstance().getConnection();
    }

    @Override
    public ApiResponse reserveCourt(Reservation reservation) {

        PreparedStatement preparedStatement=null;
        ApiResponse result = new ApiResponse();
        try {
            preparedStatement = connection
                    .prepareStatement("insert into  recmgmt.reservation (court_id,user_id,start_time,end_time,start_date,end_date) values ( ?, ?, ?, ?, ?,?)");
            preparedStatement.setInt(1, reservation.getCourt_id());
            preparedStatement.setInt(2, reservation.getUser_id());
            preparedStatement.setDate(3, reservation.getDuration().getStartTime());
            preparedStatement.setDate(4, reservation.getDuration().getEndTime());
            preparedStatement.setDate(5, reservation.getDuration().getStartDate());
            preparedStatement.setDate(6, reservation.getDuration().getEndDate());
            preparedStatement.executeUpdate();
            result.setSuccess(true);
            result.setMessage("Reservation Successfull");

        } catch (SQLException e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("Reservation Failed");

        }

        return result;
    }

    @Override
    public void deleteCourt(int courtID) {

    }

    @Override
    public List<Court> fetchCourts() {
        return null;
    }
}
