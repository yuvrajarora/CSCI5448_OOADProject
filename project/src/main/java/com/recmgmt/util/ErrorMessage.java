package com.recmgmt.util;

public class ErrorMessage {
	private boolean success;
	private String message;
	
	public ErrorMessage() {
		this.success = true;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}	
}
