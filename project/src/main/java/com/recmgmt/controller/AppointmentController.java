package com.recmgmt.controller;

import com.recmgmt.service.AppointmentService;

public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
