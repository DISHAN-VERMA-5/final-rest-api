package com.dishan.myrestapi.user;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


//this annotation will tell SWAGGER and use its description to describe this particular object in /API
@ApiModel(description="this will tell SWAGGER about me usage and what i do")

//this will collective tell to not to show the given properties in json response
//   @JsonIgnoreProperties(value= {"firstName"})

//THIS IS FOR THE DYNAMIC FILTERING PURPOSE
@JsonFilter("UserFilter")
public class User {
	private Integer id;
	@Size(min=2,message="2 se bada likh na bro")
	
	//tell to SWAGGER that what can i do
	@ApiModelProperty(notes = "this will tell swagger about me that what can i personally do")
	private String firstName;

	//this annotation will cause this property to not to show in your json response
	//   @JsonIgnore
	@Size(min=2,message="2 se bada likh na bro")
	private String lastName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public User() {
		super();
		
	}
	public User(Integer id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
}
