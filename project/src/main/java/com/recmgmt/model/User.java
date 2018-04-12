package com.recmgmt.model;

import com.recmgmt.util.CommonDataUtil;

public class User {

	private Integer userID;
    private String userName;
    private String userPw;
    private String userType;
    private String address;
    private String phoneNum;
    private String emailID;
    private CommonDataUtil.TrainerSport trainerSport;
    
    public User() {
    }
    public User(Integer id, String userName, String userPw, String userType, String addr, String phoneNum, String email, String sport) {
    	this.userID = id;
        this.userName = userName;
        this.userPw = userPw;
        this.userType = userType;
        this.address = addr;
        this.phoneNum = phoneNum;
        this.emailID = email;
        this.trainerSport = CommonDataUtil.TrainerSport.valueOf(sport);
        
    }
    
    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer _id) {
        this.userID = _id;
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String _userName) {
        this.userName = _userName;
    }
    
    public String getUserPw() {
        return userPw;
    }
    public void setUserPw(String _usrPw) {
        this.userPw = _usrPw;
    }
    
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    public String getUserAddress() {
        return address;
    }
    public void setUserAddress(String _address) {
        this.address = _address;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String _phoneNum) {
        this.phoneNum = _phoneNum;
    }
    
    public String getEmailID() {
        return emailID;
    }
    public void setEmailID(String _email) {
        this.emailID = _email;
    }
    
    public String getTrainerSport() {
    	String type = trainerSport.name();
        return type;
    }
    public void setTrainerSport(String _sportType) {
        this.trainerSport = CommonDataUtil.TrainerSport.valueOf(_sportType);
    }
}
