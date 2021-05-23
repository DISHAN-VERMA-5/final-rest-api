package com.dishan.myrestapi.user;

import java.util.Date;

public class ResponseException {
	private Date timeStamp;
	private String message;
	private String info;
	public ResponseException() {
		super();
	}
	public ResponseException(Date timeStamp, String message, String info) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.info = info;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
