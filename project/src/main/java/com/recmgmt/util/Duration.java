package com.recmgmt.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Duration {
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private Date startDuration;
	private Date endDuration;
	
	public Duration(Date _startDate, Date _endDate) {
		this.startDuration = _startDate;
		this.endDuration = _endDate;
	}
	
	public Date getStartDuration() {
		return this.startDuration;
	}
	
	public Date getEndDuration() {
		return this.endDuration;
	}
	
	public String getStartDate(Date startDuration) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:dd:yy");
		String sDate = sdf.format(startDuration);
		return sDate;
	}
	public void setstartDuration(Date startDur) {
		this.startDuration = startDur;
	}
	
	public String getEndDate(Date endDuration) {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:dd:yy");
		String eDate = sdf.format(endDuration);
		return eDate;
	}
	public void setEndDuration(Date endDur) {
		this.endDuration = endDur;
	}
	public String getStartTime(Date startDuration) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String sTime = sdf.format(startDuration);
		return sTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime(Date endDuration) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String eTime = sdf.format(endDuration);
		return eTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}   
}
