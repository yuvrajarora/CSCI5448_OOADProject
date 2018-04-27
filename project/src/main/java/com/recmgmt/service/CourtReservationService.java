package com.recmgmt.service;

import com.recmgmt.daoImpl.CourtReservationDaoImpl;
import com.recmgmt.model.Reservation;
import com.recmgmt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String deleteReservation(int userID, int courtID) {
		//implement DB logic here
		//else
		String error = "Error Message";
		return error;
	}
	public ArrayList<String> getUserReservationList(int userID){
		//logic for Court class here
		return courtTypes; //remove this
	}
	public ArrayList<String> findAvailableSlots(int courtID,ArrayList<Integer> duration){
		//logic for Court class here
		return courtTypes; //remove this
	}
	public ArrayList<String> getCourtTypes() {
		return courtTypes;
	}

	
	
	
}
