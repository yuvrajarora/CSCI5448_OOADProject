package com.recmgmt.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Dixit Patel
 */
public class SearchConfig {
    private ArrayList<Integer> eventIds;
    private Date date;
    private ArrayList<String> eventNames;

    public ArrayList<Integer> getEventIds() {
        return eventIds;
    }

    public void setEventIds(ArrayList<Integer> eventIds) {
        this.eventIds = eventIds;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getEventNames() {
        return eventNames;
    }

    public void setEventNames(ArrayList<String> eventNames) {
        this.eventNames = eventNames;
    }
}
