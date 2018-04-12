package com.recmgmt.service;

import com.recmgmt.Model.Appointment;
import com.recmgmt.daoImpl.AppointmentDaoImpl;
import com.recmgmt.model.User;
import com.recmgmt.util.Duration;
import com.recmgmt.model.Trainer;
import java.util.ArrayList;

public class AppointmentService {
    AppointmentDaoImpl appDaoImpl;
    private ArrayList<Appointment> appointmentList;

    public boolean validateUser() {
        return validUser;
    }

    public void setValidUser(boolean validUser) {
        this.validUser = validUser;
    }

    private boolean validUser;

    private AppointmentService(){
        if(null == appDaoImpl){
            this.appDaoImpl = new AppointmentDaoImpl();
        }
    }
    public AppointmentDaoImpl getAppDaoImpl() {
        return this.appDaoImpl;
    }

    public String makeAppointment(Trainer trainer, User user, Duration duration, String appointmentType){
        String msg = "Appointment Successful";
        return msg;
    }

    public String cancelAppointment(Integer trainerId, Integer userId, Duration duration, String appointmentType){
        String msg = "Appointment Cancelled";
        return msg;
    }

    public String confirmAppointment(Integer trainerId, Integer appId, String appointmentType){
        String msg = "Appointment Cancelled";
        return msg;
    }

    public ArrayList<Appointment> getAppointmentList(Integer userId){
        return appointmentList;
    }
}
