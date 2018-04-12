package com.recmgmt.controller;

import com.recmgmt.service.CourtReservationService;
import com.recmgmt.util.Duration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @ResponseStatus(HttpStatus.CREATED)
	public String requestNewReservation(@RequestParam(value="courtId") int courtId,@RequestParam(value="userId") int userId,@RequestParam(value="start") String startTime,@RequestParam(value="end") String endTime) throws ParseException {
	    return courtReservationService.makeReservation(userId,courtId,new Duration(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(startTime),new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(endTime)));
	}
	
	public void checkAvailableSlot(int courtID, Date date) {
		
	}
	public void reserveTimeSlot(Date startTime, Date endTime) {
		
	}
}
