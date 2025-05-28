package br.com.springboot.feedbacker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.springboot.feedbacker.models.User;
import br.com.springboot.feedbacker.service.UserService;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void CreateValidUser(){
        //arrange
        User user = new User();
        user.setEmail("user@gmail.com");
        
        //act 
        boolean result = userService.createUser(user);
       
        //assert
        assertEquals(true, result);
    }

    @Test
    public void CreateInvalidUser(){
        //arrange
        User user = new User();
        user.setEmail("test user");
        
        //act 
        boolean result = userService.createUser(user);
       
        //assert
        assertEquals(false, result);
    }
}
