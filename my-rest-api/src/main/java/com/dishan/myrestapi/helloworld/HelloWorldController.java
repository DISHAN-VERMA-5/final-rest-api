package com.dishan.myrestapi.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

//this is a sample API just to start working

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;
	@GetMapping("/hello-world")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	//just to show that you can also send an object or bean over a get request 
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("this is my rest api and i can send objects also which will be shown as json objects");
	}
	
	//it will pick values accoring to request headers from different prperties files
	//the below code is just an example for internationalization this means that making this useful for different peoples of different countries
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	{
		if(messageSource==null)
			return "messageSource is null";
//		if(locale==null)
//			return "null hai bro";
		return messageSource.getMessage("good.morning.message", null,locale );
	}
}
