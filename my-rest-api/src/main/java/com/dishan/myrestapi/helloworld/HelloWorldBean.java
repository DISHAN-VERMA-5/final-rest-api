package com.dishan.myrestapi.helloworld;

//this class is just to test whther you can send objects to an API request or not
public class HelloWorldBean {
	private String message;

	public HelloWorldBean() {

	}

	public HelloWorldBean(String message) {

		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
