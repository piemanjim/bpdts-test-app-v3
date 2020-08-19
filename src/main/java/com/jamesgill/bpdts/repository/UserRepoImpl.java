package com.jamesgill.bpdts.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.jamesgill.bpdts.model.User;

/**
 * Repository class using Spring RestTemplate to access remote BPDTS
 * User services.
 * @author James Gill
 *
 */
@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	private RestTemplate restTemplate;


	@Override
	public List<User> findAll() {
		ResponseEntity<User[]> response = 
				restTemplate.getForEntity("https://bpdts-test-app-v3.herokuapp.com/users", User[].class);
		User[] users = response.getBody();
		return Arrays.asList(users);
	}

	@Override
	public User findById(long id) {
		ResponseEntity<User> response = 
				restTemplate.getForEntity("https://bpdts-test-app-v3.herokuapp.com/user/" + id, User.class);
		User user = response.getBody();
		return user;
	}
	
	@Override
	public List<User> findByCity(String city) {
		ResponseEntity<User[]> response = 
				restTemplate.getForEntity("https://bpdts-test-app-v3.herokuapp.com/city/" + city + "/users", User[].class);
		User[] users = response.getBody();
		return Arrays.asList(users);
	}

}
