package com.recmgmt.controller;

import com.recmgmt.service.CourtReservationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController

public class CourtReservationController {
	CourtReservationService courtReservationService = new CourtReservationService();

	public CourtReservationService getCourtReservationService() {
		return courtReservationService;
	}

	public void setCourtReservationService(CourtReservationService courtReservationService) {
		this.courtReservationService = courtReservationService;
	}

	@RequestMapping(path="/reserve_court",method = RequestMethod.POST)
	public void requestNewReservation(@RequestParam(value="name", defaultValue="World") String name) {
		
	}
	
	public void checkAvailableSlot(int courtID, Date date) {
		
	}
	public void reserveTimeSlot(Date startTime, Date endTime) {
		
	}
}
