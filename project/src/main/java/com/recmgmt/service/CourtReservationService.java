package com.recmgmt.service;

import com.recmgmt.daoImpl.CourtReservationDaoImpl;
import com.recmgmt.model.Reservation;
import com.recmgmt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class CourtReservationService {
	@Autowired
	CourtReservationDaoImpl courtReservationDao;

	ArrayList<String> courtTypes = new ArrayList<String>();

	public ArrayList<String> getCourtName() {
		return courtTypes;
	}
	public ApiResponse makeReservation(Reservation reservation) {
		return courtReservationDao.reserveCourt(reservation);
	}
	public ApiResponse deleteReservation(Reservation reservation) {
		return courtReservationDao.deleteCourt(reservation);
	}
	public String getUserReservationList(int userID){
		return courtReservationDao.getUserReservationList(userID);
	}

	public ArrayList<String> findAvailableSlots(int courtID,ArrayList<Integer> duration){
		//logic for Court class here
		return courtTypes; //remove this
	}
	public String fetchCourt() {
		return courtReservationDao.fetchCourts();
	}

	
}
