package com.recmgmt.service;

import java.util.*;
public class CourtReservationService {
	
	ArrayList<String> courtTypes = new ArrayList<String>();

	public ArrayList<String> getCourtName() {
		return courtTypes;
	}
	public String makeReservation(int userID, int courtID, ArrayList<Integer> duration) {
		//implement DB logic here
		//else
		String error = "Error Message";
		return error;
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
