package com.jamesgill.bpdts.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jamesgill.bpdts.model.User;


@Repository
public interface UserRepo {
	
	public List<User> findAll();
	
	public User findById(long id);
	
	public List<User> findByCity(String city);

}
