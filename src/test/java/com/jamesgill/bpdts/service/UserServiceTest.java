package com.jamesgill.bpdts.service;

import java.util.List;

import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jamesgill.bpdts.fixtures.UserFixture;
import com.jamesgill.bpdts.model.User;
import com.jamesgill.bpdts.repository.UserRepo;


public class UserServiceTest {

    @Mock
    private UserRepo repo;
    
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
 
    /**
     * Test that the correct repo method is invoked.
     */
    @Test
    public void testGetUsersInLondon() {
    	UserService service = new UserServiceImpl(repo);    	
    	List<User> londonUsers = service.getUsersInLondon();    	
    	verify(repo, times(1)).findByCity("London");
    }
    
    
    /**
     * Test that the user list is filtered down to just users near London.
     */
    @Test
    public void testGetUsersNearLondon() {
    	
    	when(repo.findAll()).thenReturn(UserFixture.getUsersOfMultipleLocations());
    	UserService service = new UserServiceImpl(repo);
    	
    	List<User> nearLondonUsers = service.getUsersNearToLondon();
    	
    	verify(repo, times(1)).findAll();
    	//Check the collection was filtered down.
    	Assertions.assertEquals(1, nearLondonUsers.size());
    }
    

    
}
