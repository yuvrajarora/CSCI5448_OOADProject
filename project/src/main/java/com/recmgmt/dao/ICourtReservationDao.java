package com.recmgmt.dao;

import com.recmgmt.model.Court;
import com.recmgmt.model.Reservation;
import com.recmgmt.util.ApiResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dixit Patel
 */
public interface ICourtReservationDao {
    public ApiResponse reserveCourt(Reservation reservation);
    public ApiResponse deleteCourt(Reservation reservation);
    public String fetchCourts();
    public String getUserReservationList(int userID);
}
