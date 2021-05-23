package com.dishan.myrestapi.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class UserController {
	@Autowired
	private UserDao service;

	@GetMapping("/users")
	public MappingJacksonValue findAllUsers() {
		//normal return
		//return service.findAll();	
		//JSON DYNAMIC FILTERING
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "firstName","lastName");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(service.findAll());
		//System.out.println("dishan verma");
		List<User> x=service.findAll();
		for(User y:x) {
			System.out.println(y.getFirstName()+" "+y.getLastName()+" "+y.getId());
		}
		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping("/users/{id}")
	public MappingJacksonValue findUser(@PathVariable Integer id) {
//		User user= service.findOne(id);
//		if(user==null)
//			throw new UserNotFoundException("not able to find user with id - "+id);
//		return user;

		// THE BELOW CODE IS TO ADD DYNAMIC FILTERING IN YOUR REST API
		//MEANS SHOW ONLY SOME OF THE FIELDS ACCORDING TO THE REQUEST
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("not able to find user with id - " + id);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "firstName","lastName");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(user);
		mapping.setFilters(filters);
		System.out.println(user.getFirstName());
		return mapping;

	}

//	@GetMapping("/users/{id}")
//	public Response<User> findUser(@PathVariable Integer id)
//	{
//		User user= service.findOne(id);
//		if(user==null)
//			throw new UserNotFoundException("not able to find user with id - "+id);
//		Resource<User> resource = new Resource<User>(user);
//
//		  ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllUsers());
//
//		  resource.add(linkTo.withRel("all-users"));
//
//		  return resource;
//	}

	// @valid annotation will basically start the validation checkup into dedicated
	// object or you can saya user object
	@PostMapping("/users")
	//public ResponseEntity<Object> save(@Valid @RequestBody User user) {
	public String save(@Valid @RequestBody User user) {
		String currentlySavedUser = service.save(user);
		return currentlySavedUser;
		//JUST FOR MAKING YOUR REQUEST COMPLETE BY RETURNING PROPER PATH AND MESSAGE
//		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//				.buildAndExpand(currentlySavedUser.getId()).toUri();
//		return new ResponseEntity<>(location, HttpStatus.CREATED);

	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable Integer id) {
		String user = service.deleteUser(id);
		if (user == null)
			throw new UserNotFoundException("not able to find user with id - " + id);
		return user;
	}
}
