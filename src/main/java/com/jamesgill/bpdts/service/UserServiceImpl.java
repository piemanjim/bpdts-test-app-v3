package com.jamesgill.bpdts.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jamesgill.bpdts.model.User;
import com.jamesgill.bpdts.repository.UserRepo;
import com.jamesgill.bpdts.utils.GeoUtils;

/**
 * Service class for accessing the User repository level functions. Uses constructor injection
 * rather than field injection.
 * @author James Gill
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserRepo userRepo;
	
	/**
	 * Constructor.
	 * @param userRepo
	 */
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}


	/**
	 * Simple pass-through to repo.
	 */
	@Override
	public List<User> getUsersInLondon() {
		List<User> inLondon = userRepo.findByCity("London");
		LOGGER.info("Users listed in London = " + inLondon.size());
		return inLondon;
	}


	/**
	 * Retrieve all users and check which are near London
	 */
	@Override
	public List<User> getUsersNearToLondon() {
		List<User> allUsers = userRepo.findAll();
		LOGGER.info("Total users = " + allUsers.size());
		//Filter the users
		List<User> filteredUsers = allUsers
				.stream()
				.filter(u -> GeoUtils.isNearLondon(u.getLatitude(), u.getLongitude()))
				.collect(Collectors.toList());
		LOGGER.info("Users near London = " + filteredUsers.size());
		return filteredUsers;
	}

}
