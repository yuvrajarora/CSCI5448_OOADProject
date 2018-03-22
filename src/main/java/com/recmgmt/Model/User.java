package com.recmgmt.Model;

import com.recmgmt.enums.TrainerSport;
import com.recmgmt.enums.userType;

public class User {

	private Integer userID;
    private String userName;
    private String userPw;
    private userType usrType;
    private String address;
    private String phoneNum;
    private String emailID;
    private TrainerSport trainerSport;
    
    public User() {
    }
    public User(Integer _id, String _userName, String _userPw, String _usrType, String _addr, String _phoneNum, String _email, String _sport) {
    	this.userID = _id;
        this.userName = _userName;
        this.userPw = _userPw;
        this.usrType = userType.valueOf(_usrType);
        this.address = _addr;
        this.phoneNum = _phoneNum;
        this.emailID = _email;
        this.trainerSport = TrainerSport.valueOf(_sport);
        
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
    	String type = usrType.name();
        return type;
    }
    public void setUserType(String _usrType) {
        this.usrType = userType.valueOf(_usrType);
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
        this.trainerSport = TrainerSport.valueOf(_sportType);
    }
}
