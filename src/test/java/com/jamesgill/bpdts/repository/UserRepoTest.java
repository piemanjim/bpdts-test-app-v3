package com.jamesgill.bpdts.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.jamesgill.bpdts.fixtures.ResponseEntityFixture;
import com.jamesgill.bpdts.model.User;


@SpringBootTest()
public class UserRepoTest {

    @Mock
    private RestTemplate restTemplate;
 
    @InjectMocks
    private UserRepo repo = new UserRepoImpl();
 
    @Test
    public void testGetAllUsers() {
    	Mockito.when(restTemplate.getForEntity("https://bpdts-test-app-v3.herokuapp.com/users", User[].class))
    	.thenReturn(ResponseEntityFixture.getUserListResponseEntity(10));
    	
    	List<User> users = repo.findAll();
    	
    	Assertions.assertEquals(10, users.size());
    }
    
    @Test
    public void testGetUserById() {
    	Mockito.when(restTemplate.getForEntity("https://bpdts-test-app-v3.herokuapp.com/user/6", User.class))
    	.thenReturn(ResponseEntityFixture.getUserResponseEntity(6));
    	
    	User user = repo.findById(6);
    	
    	Assertions.assertEquals(6, user.getId());
    }
    
    @Test
    public void testGetUsersByCity() {
    	Mockito.when(restTemplate.getForEntity("https://bpdts-test-app-v3.herokuapp.com/city/London/users", User[].class))
    	.thenReturn(ResponseEntityFixture.getLondonUserListResponseEntity(5));
    	
    	List<User> users = repo.findByCity("London");
    	
    	Assertions.assertEquals(5, users.size());
    }
    
}
