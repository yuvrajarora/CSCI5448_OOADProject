package com.recmgmt.util;

public class ApiResponse {
	private boolean success;
	private String message;
	
	public ApiResponse() {
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
	public void setMessage(String message) {
		this.message = message;
	}
}