package com.recmgmt.dao;

import com.recmgmt.model.Court;

import java.util.*;
public interface ICourtDao {
public void insertCourt(Court crt);
public void deleteCourt(int courtID);
public List<Court> fetchCourts();
}

