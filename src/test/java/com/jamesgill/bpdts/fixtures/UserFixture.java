package com.jamesgill.bpdts.fixtures;

import java.util.ArrayList;
import java.util.List;

import com.jamesgill.bpdts.model.User;

public class UserFixture {

	
	public static User[] getUsers(int length) {
		List<User> users = new ArrayList<User>();
		for(int i=0; i<length; i++) {
			User user = new User();
			user.setId(length);
			user.setFirstName("firstName"+length);
			user.setLastName("lastName"+length);
			user.setLatitude(50.0);
			user.setLongitude(1.0);
			users.add(user);
		}
		User[] u = new User[users.size()];
		u = users.toArray(u);
		return u;
	}
	
	
	public static User[] getLondonUsers(int length) {
		List<User> users = new ArrayList<User>();
		for(int i=0; i<length; i++) {
			User user = new User();
			user.setId(length);
			user.setFirstName("firstName"+length);
			user.setLastName("lastName"+length);
			user.setLatitude(51.509865);
			user.setLongitude(-0.118092);
			user.setCity("London");
			users.add(user);
		}
		User[] u = new User[users.size()];
		u = users.toArray(u);
		return u;
	}
	
	
	public static User getUser(int id) {
		User user = new User();
		user.setId(id);
		user.setFirstName("firstName"+id);
		user.setLastName("lastName"+id);
		user.setLatitude(51.509865);
		user.setLongitude(-0.118092);
		user.setCity("London");
		return user;
	}
	
	/**
	 * Returns two users. One near London, one not.
	 * @return
	 */
	public static List<User> getUsersOfMultipleLocations() {
		List<User> users = new ArrayList<User>();

		User nearLondon = new User();
		nearLondon.setId(1);
		nearLondon.setFirstName("firstName1");
		nearLondon.setLastName("lastName1");
		nearLondon.setLatitude(51.7);
		nearLondon.setLongitude(0.1);
		users.add(nearLondon);
		
		User outsideLondon = new User();
		outsideLondon.setId(2);
		outsideLondon.setFirstName("firstName2");
		outsideLondon.setLastName("lastName2");
		outsideLondon.setLatitude(53.0);
		outsideLondon.setLongitude(0.1);
		users.add(outsideLondon);

		return users;
	}
	
}
