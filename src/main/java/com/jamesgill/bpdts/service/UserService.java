package com.jamesgill.bpdts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jamesgill.bpdts.model.User;


@Service
public interface UserService {
	
	public List<User> getUsersInLondon();
	
	public List<User> getUsersNearToLondon();

}
