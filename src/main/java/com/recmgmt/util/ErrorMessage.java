package com.recmgmt.util;

public class ErrorMessage {
	private boolean success;
	
	public ErrorMessage() {
		this.success = true;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getErrorMsg() {
		String errMsg = "Dummy Error Msg";
		return errMsg;
	}	
}
