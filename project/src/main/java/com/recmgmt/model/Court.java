package com.recmgmt.model;


import com.recmgmt.util.CommonDataUtil;

public class Court {
private int courtID;
private String name;
private CommonDataUtil.CourtReservationType resType;

public Court(){}

public Court(int _courtID, String _name, String resType1) {
this.courtID = _courtID;
this.name = _name;
this.resType = CommonDataUtil.CourtReservationType.valueOf(resType1);
}

public int getCourtID() {
	return courtID;
}
public void setCourtID(int courtID) {
	this.courtID = courtID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getResType() {
	String type = resType.name();
	return type;
}
public void setResType(String _resType) {
	this.resType = CommonDataUtil.CourtReservationType.valueOf(_resType);
}

}
