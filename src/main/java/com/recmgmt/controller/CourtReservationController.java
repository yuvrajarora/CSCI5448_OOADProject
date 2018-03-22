package com.recmgmt.controller;

import com.recmgmt.service.CourtReservationService;

import java.util.*;
public class CourtReservationController {
	CourtReservationService courtReservationService = new CourtReservationService();

	public CourtReservationService getCourtReservationService() {
		return courtReservationService;
	}

	public void setCourtReservationService(CourtReservationService courtReservationService) {
		this.courtReservationService = courtReservationService;
	}
	
	public void requestNewReservation() {
		
	}
	
	public void checkAvailableSlot(int courtID, Date date) {
		
	}
	public void reserveTimeSlot(Date startTime, Date endTime) {
		
	}
}
