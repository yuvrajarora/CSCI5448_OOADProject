package com.recmgmt.controller;

import com.recmgmt.service.CourtReservationService;
//import com.recmgmt.service.EventService;

/**
 * @author Dixit Patel
 */
@org.springframework.stereotype.Controller
public class Controller {
    //TODO Refactor some logic from other controllers
    private CourtReservationService courtReservationService;
    //private EventService eventService ;

    public CourtReservationService getCourtReservationService() {
        return courtReservationService;
    }

    public void setCourtReservationService(CourtReservationService courtReservationService) {
        this.courtReservationService = courtReservationService;
    }

    /*//public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }*/
}
