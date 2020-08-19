package com.jamesgill.bpdts.rest;

import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jamesgill.bpdts.model.User;
import com.jamesgill.bpdts.service.UserService;


public class UserControllerTest {

    @Mock
    private UserService service;
    
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
 
    /**
     * Test that the correct service methods are invoked.
     */
    @Test
    public void testGetUsersInOrNearLondon() {
    	UserController controller = new UserController(service);    	
    	List<User> users = controller.getUsersInOrNearLondon();    	
    	verify(service, times(1)).getUsersInLondon();
    	verify(service, times(1)).getUsersNearToLondon();
    }
    
    

    

    
}
