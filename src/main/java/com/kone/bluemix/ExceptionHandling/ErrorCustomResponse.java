package com.kone.bluemix.ExceptionHandling;

public class ErrorCustomResponse {

	

	private String message, detail;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return "ErrorCustomResponse [message=" + message + ", detail=" + detail + "]";
	}
	
	
	

}
