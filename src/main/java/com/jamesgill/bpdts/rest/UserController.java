package com.jamesgill.bpdts.rest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamesgill.bpdts.model.User;
import com.jamesgill.bpdts.service.UserService;


@RestController
public class UserController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users/nearlondon")
	public List<User> getUsersInOrNearLondon() {
		LOGGER.info("Getting users in or near London");
		List<User> usersInOrNearLondon;
		
		//Get users in London
		List<User> londonUsers = userService.getUsersInLondon();
		//Get users near to London
		List<User> nearUsers = userService.getUsersNearToLondon();
		//Merge the two lists removing duplicates
		usersInOrNearLondon = Stream.concat(londonUsers.stream(), nearUsers.stream())
				.distinct()
				.collect(Collectors.toList());		
		
		return usersInOrNearLondon;
	}

}
