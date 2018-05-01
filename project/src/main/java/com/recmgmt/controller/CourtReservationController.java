package com.recmgmt.controller;

import com.recmgmt.model.Reservation;
import com.recmgmt.service.CourtReservationService;
import com.recmgmt.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

/**
 * @author Yuvraj Arora
 */

@RestController
public class CourtReservationController {

	@Autowired
	CourtReservationService courtReservationService;

	public CourtReservationService getCourtReservationService() {
		return courtReservationService;
	}

	public void setCourtReservationService(CourtReservationService courtReservationService) {
		this.courtReservationService = courtReservationService;
	}

	@RequestMapping(path="/reserve_court",method = RequestMethod.POST,headers="Content-Type=application/json")
    @ResponseStatus(HttpStatus.CREATED)
	public ApiResponse requestNewReservation(@RequestBody Reservation reservation) throws ParseException {
		return courtReservationService.makeReservation(reservation);
	}

	@RequestMapping(path="/delete_reservation",method = RequestMethod.POST,headers="Content-Type=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ApiResponse deleteReservation(@RequestBody Reservation reservation) throws ParseException {
		return courtReservationService.deleteReservation(reservation);
	}

	@RequestMapping(path="/fetchCourt",method = RequestMethod.GET,headers="Content-Type=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public String fetchCourt() throws ParseException {
		return courtReservationService.fetchCourt();
	}

	@RequestMapping(path="/fetchUser",method = RequestMethod.POST,headers="Content-Type=application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public String  getUserReservationList(@RequestBody int userID) throws ParseException {
		return courtReservationService.getUserReservationList(userID);
	}

	public void checkAvailableSlot(int courtID, Date date) {
		
	}
	public void reserveTimeSlot(Date startTime, Date endTime) {
		
	}
}
