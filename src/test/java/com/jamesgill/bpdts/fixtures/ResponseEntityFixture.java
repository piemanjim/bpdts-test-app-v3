package com.jamesgill.bpdts.fixtures;

import org.springframework.http.ResponseEntity;

import com.jamesgill.bpdts.model.User;

public class ResponseEntityFixture {
	
	public static ResponseEntity<User[]> getUserListResponseEntity(int length) {
		return ResponseEntity.ok(UserFixture.getUsers(length));
	}
	
	public static ResponseEntity<User[]> getLondonUserListResponseEntity(int length) {
		return ResponseEntity.ok(UserFixture.getLondonUsers(length));
	}
	
	public static ResponseEntity<User> getUserResponseEntity(int id) {
		return ResponseEntity.ok(UserFixture.getUser(id));
	}

}
