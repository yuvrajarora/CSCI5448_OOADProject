package com.recmgmt.model;

import com.recmgmt.model.User;

public class Trainer extends User {
    private Integer trainerID;
    private String trainerType;

    public Integer getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(Integer trainerID) {
        this.trainerID = trainerID;
    }

    public String getTrainerType() {
        return trainerType;
    }

    public void setTrainerType(String trainerType) {
        this.trainerType = trainerType;
    }
}
