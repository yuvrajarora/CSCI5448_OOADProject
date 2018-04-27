package com.recmgmt.dao;

import com.recmgmt.model.Court;
import com.recmgmt.model.Reservation;
import com.recmgmt.util.ApiResponse;

import java.util.List;

/**
 * @author Dixit Patel
 */
public interface ICourtReservationDao {
    public ApiResponse reserveCourt(Reservation reservation);
    public void deleteCourt(int courtID);
    public List<Court> fetchCourts();
}
