package com.recmgmt.model;

import com.recmgmt.util.Duration;

public class Appointment {
    private Integer trainerID;
    private Duration duration;
    private Integer appointmentID;
    private Integer appointeeID;
    private String appointmentType;

    public Appointment() {}

    public Appointment (Integer _appId, Integer _trainerID, Duration _duration,
                        Integer _appointeeId, String _appType) {
        this.appointmentID = _appId;
        this.trainerID = _trainerID;
        this.duration = _duration;
        this.appointeeID = _appointeeId;
        this.appointmentType = _appType;
    }

    public Integer getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Integer getAppointeeID() {
        return appointeeID;
    }

    public void setAppointeeID(Integer appointeeID) {
        this.appointeeID = appointeeID;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
