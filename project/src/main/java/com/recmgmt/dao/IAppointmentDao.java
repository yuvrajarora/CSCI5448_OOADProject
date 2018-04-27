package com.recmgmt.dao;

import com.recmgmt.model.Appointment;
import com.recmgmt.util.Duration;

public interface IAppointmentDao {
    public String setAppointment (Integer _appId, Integer _trainerID, Duration _duration,
                                  Integer _appointeeId, String _appType);
    public Appointment getAppointment (Integer appointmentID);
    public String deleteAppointment (Integer appointmentID);
}
